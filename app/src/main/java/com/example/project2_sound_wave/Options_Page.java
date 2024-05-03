package com.example.project2_sound_wave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.databinding.ActivityOptionsPageBinding;

public class Options_Page extends AppCompatActivity {
    private static final String OPTIONS_PAGE_USER_ID = "com.example.project2_sound_wave.OPTIONS_PAGE_USER_ID";
    static final String SHARED_PREFERENCE_USER_ID_KEY = "com.example.project2_sound_wave.SHARED_PREFERENCE_USER_ID_KEY";
    public static final String TAG = "SOUNDWAVE";
    private static final int LOGGED_OUT = -1;
    private static final String SAVED_INSTANCE_STATE_USERID_KEY = "com.example.project2_sound_wave.SAVED_INSTANCE_STATE_USERID_KEY";

    ActivityOptionsPageBinding binding;

    SoundWaveRepository repository;

    private int loggedInUserId = -1;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOptionsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());

        loginUser(savedInstanceState);

        // User is not logged in at this point, go to login screen
        if (loggedInUserId == LOGGED_OUT) {
            Intent intent = Login_Page.loginIntentFactory(getApplicationContext(), loggedInUserId);
            startActivity(intent);
        }

        updateSharedPreference();

        binding.myPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = User_Playlist_Page.userPlaylistIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        binding.browseArtistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Browse_Artists_Page.browseArtistsPageIntentFactory(getApplicationContext(), loggedInUserId);
                startActivity(intent);
            }
        });

        binding.recentlyAddedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = Recently_Added_Page.recentlyAddedPageIntentFactory(getApplicationContext());
               startActivity(intent);
            }
        });

        binding.browseByGenreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainActivity.mainActivityIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        binding.adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Admin_Settings_Page.adminSettingsPageIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

    }


    private void loginUser(Bundle savedInstanceState) {
        //check shared preference for logged in user, read from file
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);

        loggedInUserId = sharedPreferences.getInt(getString(R.string.preference_userId_key), LOGGED_OUT);

        if (loggedInUserId == LOGGED_OUT && savedInstanceState != null && savedInstanceState.containsKey(SAVED_INSTANCE_STATE_USERID_KEY)) {
            loggedInUserId = savedInstanceState.getInt(SAVED_INSTANCE_STATE_USERID_KEY, LOGGED_OUT);
        }
        if (loggedInUserId == LOGGED_OUT) {
            loggedInUserId = getIntent().getIntExtra(OPTIONS_PAGE_USER_ID, LOGGED_OUT);
        }
        if(loggedInUserId == LOGGED_OUT) {
            return;
        }
        LiveData<User> userObserver = repository.getUserByUserId(loggedInUserId);
        userObserver.observe(this, user -> {
            this.user = user;
            if (this.user != null) {
                if (this.user.isAdmin()) {
                    binding.adminButton.setVisibility(View.VISIBLE);
                }
                invalidateOptionsMenu();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVED_INSTANCE_STATE_USERID_KEY, loggedInUserId);
        updateSharedPreference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.logoutMenuItem);
        item.setVisible(true);
        if (user == null) {
            return false;
        }
        item.setTitle(user.getUsername());
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                showLogOutDialog();
                return false;
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }

    private void showLogOutDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Options_Page.this);
        final AlertDialog alertDialog = alertBuilder.create();

        alertBuilder.setMessage("Are you sure you want to sign out?");
        alertBuilder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                logout();
            }
        });

        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertBuilder.create().show();

    }

    private void logout() {
        loggedInUserId = LOGGED_OUT;
        updateSharedPreference();
        getIntent().putExtra(OPTIONS_PAGE_USER_ID, loggedInUserId);

        startActivity(Login_Page.loginIntentFactory(getApplicationContext(), loggedInUserId));
    }

    private void updateSharedPreference() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        sharedPrefEditor.putInt(getString(R.string.preference_userId_key), loggedInUserId);
        sharedPrefEditor.apply();
    }

    static Intent optionsPageIntentFactory(Context context, int userId) {
        Intent intent = new Intent(context, Options_Page.class);
        intent.putExtra(OPTIONS_PAGE_USER_ID, userId);
        return intent;
    }
}