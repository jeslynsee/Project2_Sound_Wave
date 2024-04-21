package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.databinding.ActivityLoginPageBinding;

public class Login_Page extends AppCompatActivity {

    public static final String TAG = "SOUNDWAVE";
    ActivityLoginPageBinding binding;
//    private User user = null;

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
                verifyUser();
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

    private void verifyUser() {
        String username = binding.usernameTextEdit.getText().toString();
        if (username.isEmpty()) {
            toastMaker("Cannot have blank Username");
            return;
        }
        LiveData<User> userObserver = repository.getUserByUserName(username);
        userObserver.observe(this, user -> {
            if (user != null) {
                String password = binding.passwordEditText.getText().toString();
                if (password.equals(user.getPassword())) {
                    Intent intent = Options_Page.optionsPageIntentFactory(getApplicationContext(), user.getId());
                    startActivity(intent);
                } else {
                    toastMaker("Invalid Password");
                }
            } else {
                toastMaker(String.format("No %s found", username));
            }
        });
    }

    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent loginIntentFactory(Context context) {
        Intent intent = new Intent(context, Login_Page.class);
//        intent.putExtra(LOGIN_PAGE_USER_ID, userId);
        // need to get User info to Options Page somehow
        return intent;
    }


}