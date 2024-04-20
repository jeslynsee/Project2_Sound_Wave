package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.databinding.ActivityLoginPageBinding;

public class Login_Page extends AppCompatActivity {

    public static final String TAG = "SOUNDWAVE";
    ActivityLoginPageBinding binding;
    private SoundWaveRepository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // message displaying success for now to indicate listener works for button
                Toast.makeText(Login_Page.this, "Successfully logged in!", Toast.LENGTH_SHORT).show();
            }
        });

        //if user clicks "Sign up here", it will redirect them to Sign Up page
        binding.signUpRedirectTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // using intent here to start new activity AKA redirect user to sign up page/ start
                // sign up activity
                Intent intent = Sign_Up_Page.signUpIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    public static Intent loginIntentFactory(Context context) {
        Intent intent = new Intent(context, Login_Page.class);
        return intent;
    }

}