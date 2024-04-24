package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.project2_sound_wave.databinding.ActivityUserPlaylistPageBinding;

public class User_Playlist_Page extends AppCompatActivity {
    ActivityUserPlaylistPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserPlaylistPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


    static Intent userPlaylistIntentFactory(Context context) {
        Intent intent = new Intent(context, User_Playlist_Page.class);
        return intent;
    }
}