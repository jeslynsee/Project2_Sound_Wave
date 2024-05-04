package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.databinding.ActivityRecentlyAddedPageBinding;

public class Recently_Added_Page extends AppCompatActivity {
    ActivityRecentlyAddedPageBinding binding;
    SoundWaveRepository repository;
    public static final String RECENTLY_ADDED_USER_ID = "com.example.project2_sound_wave.RECENTLY_ADDED_USER_ID";

    private int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecentlyAddedPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());

        userId = getIntent().getIntExtra(RECENTLY_ADDED_USER_ID, 0);

        displayRecentlyAddedArtists();

        binding.clearRecentlyAddedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.LayoutForDisplayingArtists.removeAllViews();
                Toast.makeText(Recently_Added_Page.this, "Successfully cleared your Recently Added!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.addArtistRedirectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Browse_Artists_Page.browseArtistsPageIntentFactory(getApplicationContext(), userId);
                startActivity(intent);
            }
        });
    }

    private void displayRecentlyAddedArtists() {
        LiveData<String> liveDataUsername = repository.getUserNameByUserId(userId);
        liveDataUsername.observe(Recently_Added_Page.this, new Observer<String>() {
            @Override
            public void onChanged(String username) {
                repository.getPlaylistByUserName(username).observe(Recently_Added_Page.this, new Observer<Playlist>() {
                    @Override
                    public void onChanged(Playlist playlist) {
                        LinearLayout displayRecentlyAddedArtists = binding.LayoutForDisplayingArtists;
                        displayRecentlyAddedArtists.removeAllViews();

                        if (playlist.getArtist5() != null) {
                            addArtistDisplay(displayRecentlyAddedArtists, playlist.getArtist5());
                        }

                        if (playlist.getArtist4() != null) {
                            addArtistDisplay(displayRecentlyAddedArtists, playlist.getArtist4());
                        }

                        if (playlist.getArtist3() != null) {
                            addArtistDisplay(displayRecentlyAddedArtists, playlist.getArtist3());
                        }

                        if (playlist.getArtist2() != null) {
                            addArtistDisplay(displayRecentlyAddedArtists, playlist.getArtist2());
                        }

                        if (playlist.getArtist1() != null) {
                            addArtistDisplay(displayRecentlyAddedArtists, playlist.getArtist1());
                        } else {
                            addArtistDisplay(displayRecentlyAddedArtists, "Playlist empty");
                        }

                    }
                });
            }
        });

    }

    private void addArtistDisplay(LinearLayout artistLayout, String artist) {
        if (artist!= null) {
            TextView textView = new TextView(Recently_Added_Page.this);
            textView.setText(artist);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            textView.setGravity(Gravity.CENTER);
            artistLayout.addView(textView);
        }
    }

    static Intent recentlyAddedPageIntentFactory(Context context, int userId) {
        Intent intent = new Intent(context, Recently_Added_Page.class);
        intent.putExtra(RECENTLY_ADDED_USER_ID, userId);
        return intent;
    }

}