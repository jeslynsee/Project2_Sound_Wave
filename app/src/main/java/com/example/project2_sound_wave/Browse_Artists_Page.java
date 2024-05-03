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
import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.databinding.ActivityBrowseArtistsPageBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Browse_Artists_Page extends AppCompatActivity {
    ActivityBrowseArtistsPageBinding binding;

    private static final String BROWSE_ARTISTS_KEY = "com.example.project2_sound_wave.BROWSE_ARTISTS_KEY";

    SoundWaveRepository repository;

    private int userId;

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

    private void showAddArtistDialog(String artist, String genre) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Browse_Artists_Page.this);
        alertBuilder.setTitle("Adding Artist");
        alertBuilder.setMessage("Are you sure you want to add " + artist + " to your playlist?");

        alertBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
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


//    public void addArtistAndGenreToUserPlaylist(String artist, String genre) {
////TODO: Finish implementing logic
//        LiveData<String> liveDataUsername = repository.getUserNameByUserId(userId);
//        liveDataUsername.observe(Browse_Artists_Page.this, new Observer<String>() {
//            @Override
//            public void onChanged(String username) {
//                LiveData<Integer> slot = checkNextEmptySlot(artist, genre);
//                int slotNum = -1;
//                if (slot != null) {
//                    slotNum = slot.getValue();
//                }
//
//                toastMaker(String.format(Locale.ENGLISH, "Next empty slot = %d", slotNum));
//            }
//        });
// Good news is artists are being updated into the playlist table to the user it belongs too, but
        //problem is we need to check the next empty slot and fill that and break
        // right now it doesn't break, so if i have a new user, i add one artist, it duplicates
        // because it adds in artist1 and artist2


//    }



//    public void addArtistAndGenreToUserPlaylist(String artist, String genre) {
//        LiveData<String> liveDataUsername = repository.getUserNameByUserId(userId);
//        liveDataUsername.observe(Browse_Artists_Page.this, new Observer<String>() {
//            @Override
//            public void onChanged(String username) {
//                checkNextEmptySlot(artist, genre).observe(Browse_Artists_Page.this, new Observer<Integer>() {
//                    @Override
//                    public void onChanged(Integer slot) {
//                        toastMaker(String.format(Locale.ENGLISH, "Next empty slot = %d", slot));
//                        if (slot == 1) {
//                            repository.getArtist1(username).observe(Browse_Artists_Page.this, new Observer<String>() {
//                                @Override
//                                public void onChanged(String artistInTable) {
//                                    repository.updateArtist1(artist, username);
//                                    toastMaker("Successfully added artist to playlist!");
//                                    // remove artist observer
//                                    repository.getArtist1(username).removeObserver(this);
//
//                            repository.getGenre1(username).observe(Browse_Artists_Page.this, new Observer<String>() {
//                                @Override
//                                public void onChanged(String genreInTable) {
//                                    repository.updateGenre1(genre, username);
//                                    //remove genre observer
//                                    repository.getGenre1(username).removeObserver(this);
//                                }
//                            });
//                        }
//
//                    });
//
//                        }
//                    }
//                });
//            }
//        });
//    }

    public void addArtistAndGenreToUserPlaylist(String artist, String genre) {
        LiveData<String> liveDataUsername = repository.getUserNameByUserId(userId);

        liveDataUsername.observe(Browse_Artists_Page.this, new Observer<String>() {
            LiveData<Integer> slotLiveData = checkNextEmptySlot();
            @Override
            public void onChanged(String username) {
                slotLiveData.observe(Browse_Artists_Page.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer slot) {
                        if (slot == 1) {
                            repository.getArtist1(username).observe(Browse_Artists_Page.this, new Observer<String>() {
                                @Override
                                public void onChanged(String artistInTable) {
                                    boolean toastShown = false;
                                    repository.updateArtist1(artist, username);
                                        toastMaker("Successfully added artist to playlist!");

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
                                    toastMaker("Successfully added artist to playlist!");
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
                        slotLiveData.removeObserver(this);
                    }

                });
            }
        });
    }


    private LiveData<Integer> checkNextEmptySlot() {
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
//                            slotLiveData.setValue(2);
                            slot = 2;
                            repository.getPlaylistByUserName(username).removeObserver(this);
                        } else if (playlist.getArtist3() == null) {
//                            slotLiveData.setValue(3);
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