package com.example.project2_sound_wave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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
    Button Bluesbutton;
    Button Chillbutton;
    Button Classicalbutton;
    Button Countrybutton;
    Button Electronicbutton;
    Button Folkbutton;
    Button HipHopbutton;
    Button Indiebutton;
    Button Jazzbutton;
    Button Latinbutton;
    Button Metalbutton;
    Button Operabutton;
    Button Psychedelicbutton;

    Button Rapbutton;
    Button RandBbutton;
    Button Soulbutton;
    Button Trapbutton;

    String selectedAltArtist = "Gorillaz";
    String selectedBluesArtist = "B.B. King";
    String selectedChillArtist = "Jaden";
    String selectedClassicalArtist = "Vivaldi";
    String selectedCountryArtist = "Taylor Swift";
    String selectedElectronicArtist = "Daft Punk";
    String selectedFolkArtist = "Bob Dylan";
    String selectedHipHopArtist = "Eminem";
    String selectedIndieArtist = "Imagine Dragons";
    String selectedJazzArtist = "Louis Armstrong";
    String selectedLatinArtist = "Vicente Fernández";
    String selectedMetalArtist = "Guns N' Roses";
    String selectedOperaArtist = "Luciano Pavarotti";
    String selectedPsychedelicArtist = "A$AP Rocky";
    String selectedRapArtist = "J. Cole";
    String selectedRandBArtist = "Micheal Jackson";
    String selectedSoulArtist = "Otis Redding";
    String selectedTrapArtist = "Travis Scott";


    //TODO: add Login user information
    private int loggedInUserId = -1;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Altbutton = findViewById(R.id.Button1);
        Bluesbutton = findViewById(R.id.Button2);
        Chillbutton = findViewById(R.id.Button3);

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

        Bluesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] BluesArtists  ={"Ray Charles", "Stevie Ray Vaughan", "B.B. King"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(BluesArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedBluesArtist = BluesArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedBluesArtist, Toast.LENGTH_SHORT).show();
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

        Chillbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] ChillArtists  ={"Mac Miller", "Jaden", "AUTUMN XO"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(ChillArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedChillArtist = ChillArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedChillArtist, Toast.LENGTH_SHORT).show();
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
        Classicalbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] ClassicalArtists  ={"Vivaldi", "Wolfgang Amadeus Mozart", "Beethoven"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(ClassicalArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedClassicalArtist = ClassicalArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedClassicalArtist, Toast.LENGTH_SHORT).show();
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
        Countrybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] CountryArtists  ={"Johnny Cash", "Taylor Swift", "Marty Robbins"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(CountryArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedCountryArtist = CountryArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedCountryArtist, Toast.LENGTH_SHORT).show();
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

        Electronicbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] ElectronicArtists  ={"Daft Punk", "Skrillex", "Avicii"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(ElectronicArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedElectronicArtist = ElectronicArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedElectronicArtist, Toast.LENGTH_SHORT).show();
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

        Folkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] FolkArtists  ={"Bob Dylan", "Steve Goodman", "Don McLean"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(FolkArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedFolkArtist = FolkArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedFolkArtist, Toast.LENGTH_SHORT).show();
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
        HipHopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] HipHopArtists  ={"Eminem", "50 Cent", "Kanye West"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(HipHopArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedHipHopArtist = HipHopArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedHipHopArtist, Toast.LENGTH_SHORT).show();
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
        Indiebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] IndieArtists  ={"Imagine Dragons", "fun.", "Nirvana"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(IndieArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedIndieArtist = IndieArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedIndieArtist, Toast.LENGTH_SHORT).show();
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

        Jazzbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] JazzArtists  ={"Louis Armstrong", "Duke Ellington", "Frank Sinatra"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(JazzArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedJazzArtist = JazzArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedJazzArtist, Toast.LENGTH_SHORT).show();
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

        Latinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] LatinArtists  ={"Vicente Fernández", "Los Tigres Del Norte", "Pitbull"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(LatinArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedLatinArtist = LatinArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedLatinArtist, Toast.LENGTH_SHORT).show();
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

        Metalbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] MetalArtists  ={"Guns N' Roses", "Metallica", "KISS"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(MetalArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedMetalArtist = MetalArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedMetalArtist, Toast.LENGTH_SHORT).show();
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
        Operabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] OperaArtists  ={"Luciano Pavarotti", "Enrico Caruso", "Jessye Norman"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(OperaArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedOperaArtist = OperaArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedOperaArtist, Toast.LENGTH_SHORT).show();
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
        Psychedelicbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] PsychedelicArtists  ={"A$AP Rocky", "The Beach Boys", "Jimi Hendrix"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(PsychedelicArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedPsychedelicArtist = PsychedelicArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedPsychedelicArtist, Toast.LENGTH_SHORT).show();
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
        Rapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] RapArtists  ={"J. Cole", "Kendrick Lamar", "Drake"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(RapArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedRapArtist = RapArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedRapArtist, Toast.LENGTH_SHORT).show();
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

        RandBbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] RandBArtists  ={"Micheal Jackson", "Chris Brown", "Erykah Badu"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(RandBArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedRandBArtist = RandBArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedRandBArtist, Toast.LENGTH_SHORT).show();
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
        Soulbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] SoulArtists  ={"Otis Redding", "Stevie Wonder", "Lauryn Hill"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(SoulArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedSoulArtist = SoulArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedSoulArtist, Toast.LENGTH_SHORT).show();
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

        Trapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }
            private void showOptionsDialog() {
                String [] TrapArtists  ={"Travis Scott", "Playboi Carti", "Lil Yachty"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Artist");
                builder.setSingleChoiceItems(TrapArtists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedTrapArtist = TrapArtists[which];
                        Toast.makeText(MainActivity.this, "You Picked: " + selectedTrapArtist, Toast.LENGTH_SHORT).show();
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





        loginUser();
        invalidateOptionsMenu();


        if (loggedInUserId == -1) {
            Intent intent = Login_Page.loginIntentFactory(getApplicationContext());
            startActivity(intent);
        }

//        binding.SubmitButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//            public void onClick(View v) {
//             Intent intent = ArtistPage.artistPageIntentFactory(getApplicationContext());
//             startActivity(intent);
//            }
//        });



    }



    private void loginUser() {
        //TODO: Make loginUser FUNCTIONAL
        user = new User("Jeslyn", "jeslyn");
        loggedInUserId = getIntent().getIntExtra(MAIN_ACTIVITY_USER_ID, -1);
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
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
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


    static Intent mainActivityIntentFactory(Context context, int userId) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MAIN_ACTIVITY_USER_ID, userId);
        return intent;
    }



}