package com.example.project2_sound_wave;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.database.entities.SoundWave;
import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.databinding.ActivityAdminSettingsPageBinding;

import java.util.List;

public class Admin_Settings_Page extends AppCompatActivity {
    ActivityAdminSettingsPageBinding binding;
    SoundWaveRepository repository;
    private Observer<User> userObserver;
    private  Observer<List<String>> addUserObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminSettingsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());

        binding.viewUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showListOfUsersDialog();
            }
        });

        binding.deleteUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteUserDialog();
            }
        });

        binding.addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddUserDialog();
            }
        });

        binding.viewArtistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showArtistListDialog();
            }
        });

        binding.deleteArtistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteArtistDialog();
            }
        });
    }

    private void showDeleteArtistDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Admin_Settings_Page.this);
        alertBuilder.setTitle("Deleting Artist");

        LinearLayout dialogLayout = new LinearLayout(this);
        dialogLayout.setOrientation(LinearLayout.VERTICAL);

        EditText editText = new EditText(this);
        editText.setHint("Enter artist to delete");
        dialogLayout.addView(editText);

        alertBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean isFound = false;
                if (editText.getText().toString().isEmpty()) {
                    toastMaker("Please enter artist to delete");
                    dialog.dismiss();
                } else {
                    String artistToDelete = editText.getText().toString();
                    List<SoundWave> allArtistsToDisplay = repository.getAllSoundWaves();
                    for (SoundWave artistInfo : allArtistsToDisplay) {
                        if (artistInfo.getArtist().equals(artistToDelete)) {
                            showArtistDeleteConfirmation(artistToDelete);
                            isFound = true;
                            break;
                        }
                    }

                    if (!isFound) {
                        toastMaker("Artist not found. Enter valid artist to delete");
                    }

                }
            }
        });

        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertBuilder.setView(dialogLayout);
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();

    }

    private void showArtistDeleteConfirmation(String artistToDelete) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Admin_Settings_Page.this);
        alertBuilder.setTitle("Delete Artist");
        alertBuilder.setMessage("Are you sure you want to delete this artist?");

        alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                List<SoundWave> allArtistsToDisplay = repository.getAllSoundWaves();
                for (SoundWave artistInfo : allArtistsToDisplay) {
                    if (artistInfo.getArtist().equals(artistToDelete)) {
                        repository.delete(artistInfo);
                        toastMaker("Artist successfully delete!");
                        break;
                    }
                }
            }
        });

        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();

    }

    private void showArtistListDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Admin_Settings_Page.this);
        alertBuilder.setTitle("All Artists");

        LinearLayout dialogLayout = new LinearLayout(this);
        dialogLayout.setOrientation(LinearLayout.VERTICAL);

        ScrollView scrollView = new ScrollView(this);
        LinearLayout addArtistsLayoutDisplay = new LinearLayout(this);
        addArtistsLayoutDisplay.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(addArtistsLayoutDisplay);
        dialogLayout.addView(scrollView);

        List<SoundWave> allArtistsToDisplay = repository.getAllSoundWaves();
        if (allArtistsToDisplay != null) {
            addArtistsLayoutDisplay.removeAllViews();
            for (SoundWave artistInfo : allArtistsToDisplay) {
                TextView artistTextView = new TextView(Admin_Settings_Page.this);
                artistTextView.setText(artistInfo.getArtist());
                addArtistsLayoutDisplay.addView(artistTextView);
            }
        } else {
            TextView textView = new TextView(Admin_Settings_Page.this);
            textView.setText(R.string.no_artists_found);
            addArtistsLayoutDisplay.addView(textView);
        }

        alertBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertBuilder.setView(dialogLayout);
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }

    private void showListOfUsersDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Admin_Settings_Page.this);
        alertBuilder.setTitle("All Users");

        LinearLayout dialogLayout = new LinearLayout(this);
        dialogLayout.setOrientation(LinearLayout.VERTICAL);

        ScrollView scrollView = new ScrollView(this);
        LinearLayout addUsernamesLayoutToDisplay = new LinearLayout(this);
        addUsernamesLayoutToDisplay.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(addUsernamesLayoutToDisplay);
        dialogLayout.addView(scrollView); // Add ScrollView to the dialog layout

        LiveData<List<String>> allUsernamesForDeleting = repository.getAllUsernames();

        allUsernamesForDeleting.observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> usernames) {
                addUsernamesLayoutToDisplay.removeAllViews(); // Clear previous views
                if (usernames != null && !usernames.isEmpty()) {
                    for (String username : usernames) {
                        TextView textView = new TextView(Admin_Settings_Page.this);
                        textView.setText(username);
                        addUsernamesLayoutToDisplay.addView(textView);
                    }
                } else {
                    TextView textView = new TextView(Admin_Settings_Page.this);
                    textView.setText(R.string.no_artists_found);
                    addUsernamesLayoutToDisplay.addView(textView);
                }
                repository.getAllUsernames().removeObservers(Admin_Settings_Page.this);
            }
        });

        alertBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();;
            }
        });

        alertBuilder.setView(dialogLayout);
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }

    private void showAddUserDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Admin_Settings_Page.this);
        alertBuilder.setTitle("Adding Users");

        LinearLayout dialogLayout = new LinearLayout(this);
        dialogLayout.setOrientation(LinearLayout.VERTICAL);

        // Add EditText to the custom layout
        EditText editText = new EditText(this);
        editText.setHint("Enter username to add");
        EditText editText1 = new EditText(this);
        editText1.setHint("Enter password");
        dialogLayout.addView(editText); // Add EditText to the dialog layout
        dialogLayout.addView(editText1);

        // Set the custom layout as the view for the AlertDialog
        alertBuilder.setView(dialogLayout);

        alertBuilder.setPositiveButton("Add New User", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (editText.getText().toString().isEmpty() || editText1.getText().toString().isEmpty()) {
                    toastMaker("Please enter both a username and password");
                    dialog.dismiss();
                } else {
                    String usernameToAdd = editText.getText().toString();
                    String passwordToAdd = editText1.getText().toString();

                   addUserObserver = new Observer<List<String>>() {
                       @Override
                       public void onChanged(List<String> usernames) {
                           if (usernames.contains(usernameToAdd)) {
                               if (addUserObserver != null) {
                                   toastMaker("Username already taken. Cannot duplicate usernames");
                               }
                               dialog.dismiss();
                           } else {
                               User newUser = new User(usernameToAdd, passwordToAdd);
                                repository.insertUser(newUser);
                                Playlist newPlaylist = new Playlist();
                                newPlaylist.setUsername(usernameToAdd);
                                repository.insertPlaylist(newPlaylist);
                                addUserObserver = null;
                                toastMaker("Successfully added new user!");
                               repository.getAllUsernamesFromPlaylistTable().removeObserver(addUserObserver);
                           }
                       }
                   };
                    repository.getAllUsernamesFromPlaylistTable().observe(Admin_Settings_Page.this, addUserObserver);
                }
            }
        });

        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                // Remove observer if dialog is dismissed
                if (addUserObserver != null) {
                    repository.getAllUsernamesFromPlaylistTable().removeObserver(addUserObserver);
                    addUserObserver = null;
                }
            }
        });
        alertDialog.show();

    }

    private void showDeleteUserDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Admin_Settings_Page.this);
        alertBuilder.setTitle("All Users");

        // Create a custom layout for the dialog
        LinearLayout dialogLayout = new LinearLayout(this);
        dialogLayout.setOrientation(LinearLayout.VERTICAL);

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
                if (usernameToDelete.isEmpty()) {
                    toastMaker("Please enter a user to delete");
                    return;
                }

                userObserver = new Observer<User>() {
                    @Override
                    public void onChanged(User user) {
                        if (user != null) {
                            showConfirmationDialog(user);
                        } else {
                            if (userObserver != null) {
                                toastMaker("User not found");
                            }
                        }
                        repository.getUserByUserName(usernameToDelete).removeObserver(userObserver);
                        userObserver = null;
                    }
                };

                repository.getUserByUserName(usernameToDelete).observe(Admin_Settings_Page.this, userObserver);

            }
        });
        alertBuilder.setNegativeButton("Cancel", null);

        // Create and show the dialog
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                repository.getAllUsernames().removeObservers(Admin_Settings_Page.this);
            }
        });
        alertDialog.show();
    }

    private void showConfirmationDialog(User user) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Admin_Settings_Page.this);
        alertBuilder.setTitle("Delete User");
        alertBuilder.setMessage("Are you sure you want to delete this user?");
        alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                repository.delete(user);
                userObserver = null;
                repository.getUserByUserName(user.getUsername()).removeObserver(userObserver);


                toastMaker("User successfully deleted");
                dialog.dismiss();
            }
        });

        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (userObserver != null) {
                    repository.getUserByUserName(user.getUsername()).removeObserver(userObserver);
                    userObserver = null;
                }

            }
        });
        alertDialog.show();
    }

    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    static Intent adminSettingsPageIntentFactory(Context context) {
        Intent intent = new Intent(context, Admin_Settings_Page.class);
        return intent;
    }
}