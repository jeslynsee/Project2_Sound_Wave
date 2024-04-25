package com.example.project2_sound_wave;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.UserDAO;
import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.databinding.ActivityAdminSettingsPageBinding;

import java.util.List;
import java.util.Objects;

public class Admin_Settings_Page extends AppCompatActivity {
    ActivityAdminSettingsPageBinding binding;
    SoundWaveRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminSettingsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());

        binding.deleteUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteUserDialog();
            }
        });
    }

//    private void showDeleteUserDialog() {
//        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Admin_Settings_Page.this);
//        alertBuilder.setTitle("Delete User");
//
//        // Create a custom layout for the dialog
//        LinearLayout dialogLayout = new LinearLayout(this);
//        dialogLayout.setOrientation(LinearLayout.VERTICAL);
//
//        // Add ScrollView to the custom layout
//        ScrollView scrollView = new ScrollView(this);
//        final LinearLayout usernamesLayout = new LinearLayout(this);
//        usernamesLayout.setOrientation(LinearLayout.VERTICAL);
//        scrollView.addView(usernamesLayout);
//
//        LiveData<List<String>> allUsernames = repository.getAllUsernames();
//        allUsernames.observe(this, new Observer<List<String>>() {
//            @Override
//            public void onChanged(List<String> usernames) {
//                usernamesLayout.removeAllViews(); // Clear previous views
//
//                if (usernames != null && !usernames.isEmpty()) {
//                    for (String username : usernames) {
//                        TextView textView = new TextView(Admin_Settings_Page.this);
//                        textView.setText(username);
//                        usernamesLayout.addView(textView);
//                    }
//                } else {
//                    TextView textView = new TextView(Admin_Settings_Page.this);
//                    textView.setText("No users found.");
//                    usernamesLayout.addView(textView);
//                }
//            }
//        });
//
//        // Add EditText to the custom layout
//        EditText editText = new EditText(this);
//        editText.setHint("Enter username to delete");
//
//        // Add ScrollView and EditText to the AlertDialog
//        alertBuilder.setView(scrollView); // Add ScrollView as the view for the dialog
//        alertBuilder.setView(editText); // Add EditText to the dialog (replaces the previous view)
//
//        // Add buttons to the dialog
//        alertBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                String usernameToDelete = editText.getText().toString();
//                // Implement deletion logic
//            }
//        });
//        alertBuilder.setNegativeButton("Cancel", null);
//
//        // Create and show the dialog
//        AlertDialog alertDialog = alertBuilder.create();
//        alertDialog.show();
//    }

    private void showDeleteUserDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Admin_Settings_Page.this);
        alertBuilder.setTitle("All Users");

        // Create a custom layout for the dialog
        LinearLayout dialogLayout = new LinearLayout(this);
        dialogLayout.setOrientation(LinearLayout.VERTICAL);

        // Add ScrollView to the custom layout
        ScrollView scrollView = new ScrollView(this);
        final LinearLayout usernamesLayout = new LinearLayout(this);
        usernamesLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(usernamesLayout);
        dialogLayout.addView(scrollView); // Add ScrollView to the dialog layout

        LiveData<List<String>> allUsernames = repository.getAllUsernames();
        allUsernames.observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> usernames) {
                usernamesLayout.removeAllViews(); // Clear previous views
                if (usernames != null && !usernames.isEmpty()) {
                    for (String username : usernames) {
                        TextView textView = new TextView(Admin_Settings_Page.this);
                        textView.setText(username);
                        usernamesLayout.addView(textView);
                    }
                } else {
                    TextView textView = new TextView(Admin_Settings_Page.this);
                    textView.setText("No users found.");
                    usernamesLayout.addView(textView);
                }
            }
        });

        // Add EditText to the custom layout
        EditText editText = new EditText(this);
        editText.setHint("Enter username to delete");
        dialogLayout.addView(editText); // Add EditText to the dialog layout

        // Set the custom layout as the view for the AlertDialog
        alertBuilder.setView(dialogLayout);

        // Add buttons to the dialog
        alertBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String usernameToDelete = editText.getText().toString();
                repository.getUserByUserName(usernameToDelete).observe(Admin_Settings_Page.this, new Observer<User>() {
                    @Override
                    public void onChanged(User user) {
                        if (user != null) {
                            repository.delete(user);
                            Toast.makeText(Admin_Settings_Page.this, "User successfully deleted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Admin_Settings_Page.this, "User not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        alertBuilder.setNegativeButton("Cancel", null);

        // Create and show the dialog
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }


    static Intent adminSettingsPageIntentFactory(Context context) {
        Intent intent = new Intent(context, Admin_Settings_Page.class);
        return intent;
    }
}