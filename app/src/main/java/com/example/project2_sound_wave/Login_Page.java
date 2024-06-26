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

    private static final String LOGIN_PAGE_USER_ID = "com.example.project2_sound_wave.LOGIN_PAGE_USER_ID";

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
                    // Store the logged-in user's ID in SharedPreferences
                    storeLoggedInUserId(user.getId());

                    // Start the Options_Page activity
                    Intent intent = Options_Page.optionsPageIntentFactory(getApplicationContext(), user.getId());
                    startActivity(intent);
                    toastMaker("Signed in successfully!");
                } else {
                    toastMaker("Invalid Password");
                }
            } else {
                toastMaker(String.format("No %s found", username));
            }
        });
    }

    private void storeLoggedInUserId(int userId) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        sharedPrefEditor.putInt(getString(R.string.preference_userId_key), userId);
        sharedPrefEditor.apply();
    }

    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent loginIntentFactory(Context context, int userId) {
        Intent intent = new Intent(context, Login_Page.class);
        intent.putExtra(LOGIN_PAGE_USER_ID, userId);
        return intent;
    }


}