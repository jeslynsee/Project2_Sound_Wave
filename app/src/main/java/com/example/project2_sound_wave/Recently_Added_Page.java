package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.project2_sound_wave.databinding.ActivityRecentlyAddedPageBinding;

public class Recently_Added_Page extends AppCompatActivity {
    ActivityRecentlyAddedPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecentlyAddedPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    static Intent recentlyAddedPageIntentFactory(Context context) {
        Intent intent = new Intent(context, Recently_Added_Page.class);
        return intent;
    }

    // display User's playlist, select in descending order to show "recently added"

}