package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.databinding.ActivityStartingPageBinding;

public class Starting_Page extends AppCompatActivity {
    private static final int LOGGED_OUT = -1;
    ActivityStartingPageBinding binding;

    SoundWaveRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());

//        handleAppStartUp();

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

//    private void handleAppStartUp() {
//        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(
//                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
//        int loggedInUserId = sharedPreferences.getInt(getString(R.string.preference_userId_key), LOGGED_OUT);
//
//        if (loggedInUserId != LOGGED_OUT) {
//            // User is logged in, start the Options_Page activity
//            Intent intent = Options_Page.optionsPageIntentFactory(this, loggedInUserId);
//            startActivity(intent);
//        } else {
//            // User is not logged in, start the Login_Page activity
////            Intent intent = Login_Page.loginIntentFactory(this);
////            startActivity(intent);
//        }
//    }

    public static Intent startingPageIntentFactory(Context context) {
        Intent intent = new Intent(context, Starting_Page.class);
        return intent;
    }

}