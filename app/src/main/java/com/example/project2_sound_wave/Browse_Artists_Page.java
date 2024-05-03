package com.example.project2_sound_wave;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.database.entities.SoundWave;
import com.example.project2_sound_wave.databinding.ActivityBrowseArtistsPageBinding;

import java.util.ArrayList;

public class Browse_Artists_Page extends AppCompatActivity {
    ActivityBrowseArtistsPageBinding binding;

    private static final String BROWSE_ARTISTS_KEY = "com.example.project2_sound_wave.BROWSE_ARTISTS_KEY";

    SoundWaveRepository repository;

    private int userId;
    Observer<Playlist> playlistObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBrowseArtistsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = SoundWaveRepository.getRepository(getApplication());

        userId = getIntent().getIntExtra(BROWSE_ARTISTS_KEY, 0);

        LinearLayout artistList = binding.artistListContainer;
        populateArtistList(artistList);

    }


    private void populateArtistList(LinearLayout artistList) {
        ArrayList<SoundWave> soundWaveData = repository.getAllLogs();

        //using enhanced for loop to go through all the artists in SoundWave db to display
        for (SoundWave data : soundWaveData) {
            View artistView = getLayoutInflater().inflate(R.layout.artist_list_item, null);

            TextView artistInfoTextView = artistView.findViewById(R.id.artist_name);
            ImageButton addToPlaylist = artistView.findViewById(R.id.add_to_playlist);

            artistInfoTextView.setText(String.format("%s    [Genre: %s]", data.getArtist(), data.getGenre()));
            addToPlaylist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAddArtistDialog(data.getArtist(), data.getGenre());
                }
            });

            artistList.addView(artistView);
        }

    }

    //artist and genre taken in from the artist user clicks on, asking in alert dialog to confirm choice
    private void showAddArtistDialog(String artist, String genre) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Browse_Artists_Page.this);
        alertBuilder.setTitle("Adding Artist");
        alertBuilder.setMessage("Are you sure you want to add " + artist + " to your playlist?");

        alertBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // slot is the number of the next empty/null artist/genre to populate
                // doing a slot check here, so toast message will only pop up once; placing toast in other places in code has gotten unwanted behavior (repeating)
                LiveData<Integer> slotLiveData = checkNextEmptySlot();
                slotLiveData.observe(Browse_Artists_Page.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer slot) {
                        if (slot != -1) {
                            toastMaker("Successfully added artist to playlist!");
                        } else {
                            toastMaker("Playlist limit exceeded. Please clear playlist to add new artist");
                        }
                        slotLiveData.removeObserver(this);
                    }
                });

                // separate method to actually do error checks and update playlist
                addArtistAndGenreToUserPlaylist(artist, genre);
            }
        });

        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertBuilder.create().show();

    }


    public void addArtistAndGenreToUserPlaylist(String artist, String genre) {
        LiveData<String> liveDataUsername = repository.getUserNameByUserId(userId);

        liveDataUsername.observe(Browse_Artists_Page.this, new Observer<String>() {
            LiveData<Integer> slotLiveData = checkNextEmptySlot();
            @Override
            public void onChanged(String username) {
                // returned slotLiveData as Live Integer and when observed, able to check Integer value to see what is next available slot for artist/genre popualtion
                slotLiveData.observe(Browse_Artists_Page.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer slot) {
                        if (slot == 1) {
                            repository.getArtist1(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                @Override
                                public void onChanged(String artistInTable) {
                                    repository.updateArtist1(artist, username);

                                    // Remove artist observer
                                    repository.getArtist1(username).removeObserver(this);

                                    repository.getGenre1(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                        @Override
                                        public void onChanged(String genreInTable) {
                                            repository.updateGenre1(genre, username);
                                            // Remove genre observer
                                            repository.getGenre1(username).removeObserver(this);
                                        }
                                    });
                                }
                            });
                        }

                        if (slot == 2) {
                            repository.getArtist2(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                @Override
                                public void onChanged(String artistInTable) {
                                    repository.updateArtist2(artist, username);
                                    // Remove artist observer
                                    repository.getArtist2(username).removeObserver(this);

                                    repository.getGenre2(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                        @Override
                                        public void onChanged(String genreInTable) {
                                            repository.updateGenre2(genre, username);
                                            // Remove genre observer
                                            repository.getGenre2(username).removeObserver(this);
                                        }
                                    });
                                }
                            });
                        }

                        if (slot == 3) {
                            repository.getArtist3(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                @Override
                                public void onChanged(String artistInTable) {
                                    repository.updateArtist3(artist, username);
                                    // Remove artist observer
                                    repository.getArtist3(username).removeObserver(this);

                                    repository.getGenre3(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                        @Override
                                        public void onChanged(String genreInTable) {
                                            repository.updateGenre3(genre, username);
                                            // Remove genre observer
                                            repository.getGenre3(username).removeObserver(this);
                                        }
                                    });
                                }
                            });
                        }

                        if (slot == 4) {
                            repository.getArtist4(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                @Override
                                public void onChanged(String artistInTable) {
                                    repository.updateArtist4(artist, username);
                                    // Remove artist observer
                                    repository.getArtist4(username).removeObserver(this);

                                    repository.getGenre4(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                        @Override
                                        public void onChanged(String genreInTable) {
                                            repository.updateGenre4(genre, username);
                                            // Remove genre observer
                                            repository.getGenre4(username).removeObserver(this);
                                        }
                                    });
                                }
                            });
                        }

                        if (slot == 5) {
                            repository.getArtist5(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                @Override
                                public void onChanged(String artistInTable) {
                                    repository.updateArtist5(artist, username);
                                    // Remove artist observer
                                    repository.getArtist5(username).removeObserver(this);

                                    repository.getGenre5(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                        @Override
                                        public void onChanged(String genreInTable) {
                                            repository.updateGenre5(genre, username);
                                            // Remove genre observer
                                            repository.getGenre5(username).removeObserver(this);
                                        }
                                    });
                                }
                            });

                        }

                        slotLiveData.removeObserver(this);
                    }

                });
            }
        });

    }


    private LiveData<Integer> checkNextEmptySlot() {
        // had to use Mutable Live Data in order to keep track of Live Data somehow to figure out next empty slot
        MutableLiveData<Integer> slotLiveData = new MutableLiveData<>();
        LiveData<String> liveDataUsername = repository.getUserNameByUserId(userId);

        liveDataUsername.observe(Browse_Artists_Page.this, new Observer<String>() {
            @Override
            public void onChanged(String username) {
                repository.getPlaylistByUserName(username).observe(Browse_Artists_Page.this, new Observer<Playlist>() {
                    @Override
                    public void onChanged(Playlist playlist) {
                        int slot = -1;
                        if (playlist.getArtist1() == null) {
                            slot = 1;
                            repository.getPlaylistByUserName(username).removeObserver(this);
                        } else if (playlist.getArtist2() == null) {
                            slot = 2;
                            repository.getPlaylistByUserName(username).removeObserver(this);
                        } else if (playlist.getArtist3() == null) {
                            slot = 3;
                            repository.getPlaylistByUserName(username).removeObserver(this);
                        } else if (playlist.getArtist4() == null) {
                            slot = 4;
                            repository.getPlaylistByUserName(username).removeObserver(this);
                        } else if (playlist.getArtist5() == null) {
                            slot = 5;
                            repository.getPlaylistByUserName(username).removeObserver(this);
                        }
                        slotLiveData.setValue(slot);

                    }
                });
            }
        });

        return slotLiveData;
    }


    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent browseArtistsPageIntentFactory(Context context, int userId) {
        Intent intent = new Intent(context, Browse_Artists_Page.class);
        intent.putExtra(BROWSE_ARTISTS_KEY, userId);
        return intent;
    }

}