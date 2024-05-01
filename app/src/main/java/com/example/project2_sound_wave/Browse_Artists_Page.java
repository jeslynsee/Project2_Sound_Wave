package com.example.project2_sound_wave;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.database.entities.SoundWave;
import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.databinding.ActivityBrowseArtistsPageBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Browse_Artists_Page extends AppCompatActivity {
    ActivityBrowseArtistsPageBinding binding;

    private static final String BROWSE_ARTISTS_KEY = "com.example.project2_sound_wave.BROWSE_ARTISTS_KEY";

    SoundWaveRepository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBrowseArtistsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());

        LinearLayout artistList = binding.artistListContainer;
        populateArtistList(artistList);

    }


    private void populateArtistList(LinearLayout artistList) {
        ArrayList<SoundWave> soundWaveData = repository.getAllLogs();

        for (SoundWave data : soundWaveData) {
            View artistView = getLayoutInflater().inflate(R.layout.artist_list_item, null);

            TextView artistInfoTextView = artistView.findViewById(R.id.artist_name);
            ImageButton addToPlaylist = artistView.findViewById(R.id.add_to_playlist);

            artistInfoTextView.setText(String.format("%s    [ Genre: %s]", data.getArtist(), data.getGenre()));
            addToPlaylist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAddArtistDialog(data.getArtist(), data.getGenre());
                }
            });

            artistList.addView(artistView);
        }

    }

    private void showAddArtistDialog(String artist, String genre) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Browse_Artists_Page.this);
        alertBuilder.setTitle("Adding Artist");
        alertBuilder.setMessage("Are you sure you want to add " + artist + " to your playlist?");

        alertBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addArtistAndGenreToUserPlaylist(artist, genre);
            }
        });

        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertBuilder.create().show();

    }


    public void addArtistAndGenreToUserPlaylist(String artist, String genre) {
        int userId = getIntent().getIntExtra(BROWSE_ARTISTS_KEY, 0);
        LiveData<String> username = repository.getUserNameByUserId(userId);

        // Observe the LiveData to get the username
        username.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String username) {
                // Use the username to fetch artists and genres
                repository.getAllArtists(username).observe(Browse_Artists_Page.this, new Observer<List<String>>() {
                    @Override
                    public void onChanged(List<String> artists) {
                        // Update artists list
                        if (artists != null) {
                            artists.add(artist);
                            toastMaker("Artist added to list");
                            // Update the database with the modified list
                            repository.updateArtistList(artists, username);
                        }
                    }
                });

                repository.getAllGenres(username).observe(Browse_Artists_Page.this, new Observer<List<String>>() {
                    @Override
                    public void onChanged(List<String> genres) {
                        // Update genres list
                        if (genres != null) {
                            genres.add(genre);
                            toastMaker("Genre added to list");
                            // Update the database with the modified list
                            repository.updateGenreList(genres, username);
                        }
                    }
                });

                toastMaker("Artist successfully added to playlist!");
            }
        });
    }




    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent browseArtistsPageIntentFactory(Context context) {
        Intent intent = new Intent(context, Browse_Artists_Page.class);
        return intent;
    }

}