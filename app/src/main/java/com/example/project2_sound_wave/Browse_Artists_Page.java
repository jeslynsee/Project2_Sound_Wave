package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.project2_sound_wave.databinding.ActivityBrowseArtistsPageBinding;

public class Browse_Artists_Page extends AppCompatActivity {
    ActivityBrowseArtistsPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBrowseArtistsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    static Intent browseArtistsPageIntentFactory(Context context) {
        Intent intent = new Intent(context, Browse_Artists_Page.class);
        return intent;
    }


}