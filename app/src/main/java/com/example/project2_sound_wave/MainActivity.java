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
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_ACTIVITY_USER_ID = "com.example.project2_sound_wave.MAIN_ACTIVITY_USER_ID";
    ActivityMainBinding binding;
    Button Altbutton;
    String selectedAltArtist = "Gorillaz";


    //TODO: add Login user information
    private int loggedInUserId = -1;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Altbutton = findViewById(R.id.Button1);
        Altbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] AltArtists  ={"Tame Impala", "Gorillaz", "Red Hot Chili Peppers"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(AltArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedAltArtist = AltArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedAltArtist, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("Add to PLayList", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                builder.show();
            }
        });



//        loginUser();
//        invalidateOptionsMenu();
//
//
//        if (loggedInUserId == -1) {
//            Intent intent = Login_Page.loginIntentFactory(getApplicationContext());
//            startActivity(intent);
//        }

//        binding.SubmitButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//            public void onClick(View v) {
//             Intent intent = ArtistPage.artistPageIntentFactory(getApplicationContext());
//             startActivity(intent);
//            }
//        });



    }



//    private void loginUser() {
//        //TODO: Make loginUser FUNCTIONAL
//        user = new User("Jeslyn", "jeslyn");
//        loggedInUserId = getIntent().getIntExtra(MAIN_ACTIVITY_USER_ID, -1);
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.logout_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        MenuItem item = menu.findItem(R.id.logoutMenuItem);
//        item.setVisible(true);
//        item.setTitle(user.getUsername());
//        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(@NonNull MenuItem item) {
//                showLogOutDialog();
//                return false;
//            }
//        });
//        return super.onPrepareOptionsMenu(menu);
//    }
//
//    private void showLogOutDialog() {
//        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
//        final AlertDialog alertDialog = alertBuilder.create();
//
//        alertBuilder.setMessage("Are you sure you want to sign out?");
//        alertBuilder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                logout();
//            }
//        });
//
//        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                alertDialog.dismiss();
//            }
//        });
//
//        alertBuilder.create().show();
//
//    }
//
//    private void logout() {
//        //TODO: Finish logout method
//        startActivity(Starting_Page.startingPageIntentFactory(getApplicationContext()));
//    }


    static Intent mainActivityIntentFactory(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }



}