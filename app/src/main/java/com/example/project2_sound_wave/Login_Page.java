package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.databinding.ActivityLoginPageBinding;

public class Login_Page extends AppCompatActivity {

    public static final String TAG = "SOUNDWAVE";
    ActivityLoginPageBinding binding;
    private User user = null;

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
                if (!verifyUser()) {
                    toastMaker("Invalid Username or Password");
                } else {
                    // message displaying success for now to indicate listener works for button
                    toastMaker("Successfully logged in!");
                    //Moved previous Intent to start MainActivity to Sign Up Page because MainActivity is a landing page for new users
                    // This intent to start up Options Page for returning users
                    Intent intent = Options_Page.optionsPageIntentFactory(getApplicationContext(), user.getId());
                    startActivity(intent);
                }
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

    private boolean verifyUser() {
        String username = binding.usernameTextEdit.getText().toString();
        if (username.isEmpty()) {
            toastMaker("Cannot have blank Username");
            return false;
        }
        user = repository.getUserByUserName(username);
        if (user != null) {
            String password = binding.passwordEditText.getText().toString();
            if (password.equals(user.getPassword())) {
                return true;
            } else {
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
            }
        }
        toastMaker(String.format("No %s found", username));
        return false;
    }

    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent loginIntentFactory(Context context) {
        Intent intent = new Intent(context, Login_Page.class);
        return intent;
    }


}