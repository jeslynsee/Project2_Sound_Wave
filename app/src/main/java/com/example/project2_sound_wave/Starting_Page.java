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
    private static final String SAVED_INSTANCE_STATE_USERID_KEY = "com.example.project2_sound_wave.SAVED_INSTANCE_STATE_USERID_KEY";
    private static final String STARTING_PAGE_USER_ID = "com.example.project2_sound_wave.STARTING_PAGE_USER_ID";
    ActivityStartingPageBinding binding;

    SoundWaveRepository repository;

    private int loggedInUserId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());
        loginUser(savedInstanceState);

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

    //TODO: Check sharee preferences, make it functional
// need to check sharedPreferences here to make sure user is still not logged in
private void loginUser(Bundle savedInstanceState) {
    //check shared preference for logged in user, read from file
    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key),
            Context.MODE_PRIVATE);

    loggedInUserId = sharedPreferences.getInt(getString(R.string.preference_userId_key), LOGGED_OUT);

    if (loggedInUserId == LOGGED_OUT && savedInstanceState != null && savedInstanceState.containsKey(SAVED_INSTANCE_STATE_USERID_KEY)) {
        loggedInUserId = savedInstanceState.getInt(SAVED_INSTANCE_STATE_USERID_KEY, LOGGED_OUT);
    }
    if (loggedInUserId == LOGGED_OUT) {
        loggedInUserId = getIntent().getIntExtra(STARTING_PAGE_USER_ID, LOGGED_OUT);
    }
    if(loggedInUserId == LOGGED_OUT) {
        return;
    }
//    LiveData<User> userObserver = repository.getUserByUserId(loggedInUserId);
//    userObserver.observe(this, user -> {
//        this.user = user;
//        if (this.user != null) {
//            if (this.user.isAdmin()) {
//                binding.adminButton.setVisibility(View.VISIBLE);
//            }
//            invalidateOptionsMenu();
//        }
//    });

}

    public static Intent startingPageIntentFactory(Context context) {
        Intent intent = new Intent(context, Starting_Page.class);
        return intent;
    }

}