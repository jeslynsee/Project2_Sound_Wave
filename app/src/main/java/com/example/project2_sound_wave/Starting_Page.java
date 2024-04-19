package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project2_sound_wave.databinding.ActivityStartingPageBinding;

public class Starting_Page extends AppCompatActivity {
    ActivityStartingPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.createAnAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Sign_Up_Page.signUpIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        binding.startingPageLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Login_Page.loginIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    public static Intent startingPageIntentFactory(Context context) {
        Intent intent = new Intent(context, Starting_Page.class);
        return intent;
    }

}