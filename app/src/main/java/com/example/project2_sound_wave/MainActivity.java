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
import android.widget.RadioButton;
import android.widget.RadioGroup;
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


    String selectedAltArtist = "Tame Impala";
    String selectedBluesArtist = "Ray Charles";
    String selectedChillArtist = "Jaden";
    String selectedClassicalArtist = "Vivaldi";
    String selectedCountryArtist = "Taylor Swift";
    String selectedElectronicArtist = "Daft Punk";
    String selectedFolkArtist = "Bob Dylan";
    String selectedHipHopArtist = "Eminem";
    String selectedIndieArtist = "Imagine Dragons";
    String selectedJazzArtist = "Louis Armstrong";
    String selectedLatinArtist = "Vicente Fernández";
    String selectedMetalArtist = "KISS";
    String selectedOperaArtist = "Luciano Pavarotti";
    String selectedPsychedelicArtist = "A$AP Rocky";
    String selectedRapArtist = "J. Cole";
    String selectedRandBArtist = "Chris Brown";
    String selectedSoulArtist = "Otis Redding";
    String selectedTrapArtist = "Travis Scott";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        Altbutton = findViewById(R.id.Button1);
        Bluesbutton = findViewById(R.id.Button2);
        Chillbutton = findViewById(R.id.Button3);
        Classicalbutton = findViewById(R.id.Button4);
        Countrybutton = findViewById(R.id.Button5);
        Electronicbutton = findViewById(R.id.Button6);
        Folkbutton = findViewById(R.id.Button7);
        HipHopbutton = findViewById(R.id.Button8);
        Indiebutton = findViewById(R.id.Button9);
        Jazzbutton = findViewById(R.id.Button10);
        Latinbutton = findViewById(R.id.Button11);
        Metalbutton = findViewById(R.id.Button12);
        Operabutton = findViewById(R.id.Button13);
        Psychedelicbutton = findViewById(R.id.Button14);
        Rapbutton = findViewById(R.id.Button15);
        RandBbutton = findViewById(R.id.Button16);
        Soulbutton = findViewById(R.id.Button17);
        Trapbutton = findViewById(R.id.Button18);

        setContentView(binding.getRoot());


        binding.Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();
            }

            private void showOptionsDialog() {
                String[] AltArtists = {"Tame Impala", "Gorillaz", "Red Hot Chili Peppers"};
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


        binding.Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();
            }

            private void showOptionsDialog() {
                String[] BluesArtists = {"Ray Charles", "Stevie Ray Vaughan", "B.B. King"};
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


        binding.Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();
            }

            private void showOptionsDialog() {
                String[] ChillArtists = {"Mac Miller", "Jaden", "AUTUMN XO"};
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
        binding.Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] ClassicalArtists = {"Vivaldi", "Wolfgang Amadeus Mozart", "Beethoven"};
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
        binding.Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] CountryArtists = {"Johnny Cash", "Taylor Swift", "Marty Robbins"};
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

        binding.Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] ElectronicArtists = {"Daft Punk", "Skrillex", "Avicii"};
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

        binding.Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] FolkArtists = {"Bob Dylan", "Steve Goodman", "Don McLean"};
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
        binding.Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] HipHopArtists = {"Eminem", "50 Cent", "Kanye West"};
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
        binding.Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] IndieArtists = {"Imagine Dragons", "fun.", "Nirvana"};
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

        binding.Button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] JazzArtists = {"Louis Armstrong", "Duke Ellington", "Frank Sinatra"};
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

        binding.Button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] LatinArtists = {"Vicente Fernández", "Los Tigres Del Norte", "Pitbull"};
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

        binding.Button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] MetalArtists = {"Guns N' Roses", "Metallica", "KISS"};
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
        binding.Button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] OperaArtists = {"Luciano Pavarotti", "Enrico Caruso", "Jessye Norman"};
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
        binding.Button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] PsychedelicArtists = {"A$AP Rocky", "The Beach Boys", "Jimi Hendrix"};
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
        binding.Button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] RapArtists = {"J. Cole", "Kendrick Lamar", "Drake"};
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

        binding.Button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] RandBArtists = {"Micheal Jackson", "Chris Brown", "Erykah Badu"};
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
        binding.Button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] SoulArtists = {"Otis Redding", "Stevie Wonder", "Lauryn Hill"};
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

        binding.Button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();

            }

            private void showOptionsDialog() {
                String[] TrapArtists = {"Travis Scott", "Playboi Carti", "Lil Yachty"};
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
        binding.PlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = User_Playlist_Page.userPlaylistIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });


    }

    static Intent mainActivityIntentFactory(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;

    }



}







