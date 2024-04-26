package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.databinding.ActivitySignUpPageBinding;

public class Sign_Up_Page extends AppCompatActivity {
    ActivitySignUpPageBinding binding;
    SoundWaveRepository repository;
    private Observer<User> userObserver;

    private static final String SIGN_UP_KEY = "com.example.project2_sound_wave.SIGN_UP_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());


        //making sure sign up button listener is working
        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });

        // if user clicks this, it will redirect them to Login page
        binding.loginRedirectTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Login_Page.loginIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

    }


    private void validateFields() {
        String username = binding.userSignUpEditText.getText().toString();
        String password = binding.passwordSignUpEditText.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            toastMaker("Cannot have empty username or password");
            return;
        }

        userObserver = new Observer<User>() {

            @Override
            public void onChanged(User user) {
                if (user != null) {
                    if (userObserver != null) {
                        toastMaker("Username already taken. Enter a different username");
                    }
                } else {
                    User newUser = new User(username, password);
                    repository.insertUser(newUser);
                    userObserver = null;
                    Toast.makeText(Sign_Up_Page.this, "Successfully signed up!", Toast.LENGTH_SHORT).show();
                    Intent intent = Login_Page.loginIntentFactory(getApplicationContext());
                    startActivity(intent);

                    repository.getUserByUserName(username).removeObserver(this);
                }
            }
        };

        repository.getUserByUserName(username).observe(Sign_Up_Page.this, userObserver);

    }


    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // created intent here, so we can start up this activity from button click in Main
    static Intent signUpIntentFactory(Context context) {// missing String username param?
        Intent intent = new Intent(context, Sign_Up_Page.class);
        intent.putExtra(SIGN_UP_KEY, "Username"); // placeholder value
        return intent;
    }

}