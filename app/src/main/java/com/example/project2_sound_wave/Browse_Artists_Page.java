package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.SoundWave;
import com.example.project2_sound_wave.databinding.ActivityBrowseArtistsPageBinding;

import java.util.ArrayList;
import java.util.List;

public class Browse_Artists_Page extends AppCompatActivity {
    ActivityBrowseArtistsPageBinding binding;
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
        //TODO: retrieve all artists from database
        ArrayList<SoundWave> soundWaveData = repository.getAllLogs();

        for (SoundWave data : soundWaveData) {
            View artistView = getLayoutInflater().inflate(R.layout.activity_browse_artists_page, null);

            TextView artistInfoTextView = artistView.findViewById(R.id.artist_name);
            ImageButton addToPlaylist = artistView.findViewById(R.id.add_to_playlist);

            artistInfoTextView.setText(String.format("%s %s", data.getArtist(), data.getGenre()));
            addToPlaylist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAddArtistDialog();
                }
            });

            artistList.addView(artistView);
        }

        //TODO: display artists next to image button

        //TODO: add artist to playlist (different method) with alert dialog when image button gets clicked on
    }

    private void showAddArtistDialog() {

    }

    static Intent browseArtistsPageIntentFactory(Context context) {
        Intent intent = new Intent(context, Browse_Artists_Page.class);
        return intent;
    }

}