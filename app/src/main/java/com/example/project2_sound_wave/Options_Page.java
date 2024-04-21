package com.example.project2_sound_wave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.databinding.ActivityOptionsPageBinding;

public class Options_Page extends AppCompatActivity {
    private static final String OPTIONS_PAGE_USER_ID = "com.example.project2_sound_wave.OPTIONS_PAGE_USER_ID";
    ActivityOptionsPageBinding binding;

    SoundWaveRepository repository;

    //TODO: add Login user information
    private int loggedInUserId = -1;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOptionsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());

        loginUser();
        invalidateOptionsMenu();


        if (loggedInUserId == -1) {
            Intent intent = Login_Page.loginIntentFactory(getApplicationContext());
            startActivity(intent);
        }
    }

    private void loginUser() {
        //TODO: Make loginUser FUNCTIONAL
        user = new User("Jeslyn", "jeslyn");
        loggedInUserId = getIntent().getIntExtra(OPTIONS_PAGE_USER_ID, -1);
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
        //TODO: Finish logout method
        startActivity(Starting_Page.startingPageIntentFactory(getApplicationContext()));
    }

    static Intent optionsPageIntentFactory(Context context, int userId) {
        Intent intent = new Intent(context, Options_Page.class);
        intent.putExtra(OPTIONS_PAGE_USER_ID, userId);
        return intent;
    }
}