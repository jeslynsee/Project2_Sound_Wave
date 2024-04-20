package com.example.project2_sound_wave;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2_sound_wave.databinding.ActivityArtistPageBinding;


public class ArtistPage extends AppCompatActivity {
    private static final String ARTIST_VALUE_EXTRA_KEY = "Artist_Page";
    ActivityArtistPageBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArtistPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }


    public static Intent artistPageIntentFactory (Context context){
        Intent intent = new Intent(context, ArtistPage.class);
        return intent;

    }
}