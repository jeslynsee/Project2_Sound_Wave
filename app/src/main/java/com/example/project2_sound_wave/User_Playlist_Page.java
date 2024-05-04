package com.example.project2_sound_wave;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.project2_sound_wave.database.SoundWaveRepository;
import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.databinding.ActivityUserPlaylistPageBinding;

public class User_Playlist_Page extends AppCompatActivity {
    ActivityUserPlaylistPageBinding binding;
    SoundWaveRepository repository;
    private static final String BROWSE_ARTISTS_KEY = "com.example.project2_sound_wave.BROWSE_ARTISTS_KEY";
    private int userId;
    private Observer<Playlist> playlistObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserPlaylistPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        repository = SoundWaveRepository.getRepository(getApplication());
        displayPlaylist();
        userId = getIntent().getIntExtra(BROWSE_ARTISTS_KEY,0);




        binding.clearPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the method to clear the table
                clearPlaylist();

                // Optionally, notify the user that data has been cleared

                Toast.makeText(getApplicationContext(), "Playlist cleared", Toast.LENGTH_SHORT).show();
            }
        });
        binding.goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Options_Page.optionsPageIntentFactory(getApplicationContext(), userId);
                startActivity(intent);
            }
        });
    }






    static Intent userPlaylistIntentFactory(Context context, int userId) {
        Intent intent = new Intent(context, User_Playlist_Page.class);
        intent.putExtra(BROWSE_ARTISTS_KEY, userId);
        return intent;
    }

    public void clearPlaylist() {
        LiveData<String> username = repository.getUserNameByUserId(userId);
        username.observe(User_Playlist_Page.this, new Observer<String>() {
            @Override
            public void onChanged(String username) {
                repository.getArtist1(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String artist1) {
                        if(artist1 != null){
                            repository.updateArtist1(null, username);
                        }

                    }
                });
                repository.getArtist2(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String artist2) {
                        if(artist2 != null){
                            repository.updateArtist2(null, username);
                        }

                    }
                });
                repository.getArtist3(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String artist3) {
                        if(artist3 != null){
                            repository.updateArtist3(null, username);
                        }

                    }
                });
                repository.getArtist4(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String artist4) {
                        if(artist4 != null){
                            repository.updateArtist4(null, username);
                        }

                    }
                });
                repository.getArtist5(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String artist5) {
                        if(artist5 != null){
                            repository.updateArtist5(null, username);
                        }

                    }
                });
                repository.getGenre1(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String genre1) {
                        if(genre1 != null){
                            repository.updateGenre1(null, username);
                        }

                    }
                });
                repository.getGenre2(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String genre2) {
                        if(genre2 != null){
                            repository.updateGenre2(null, username);
                        }

                    }
                });
                repository.getGenre3(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String genre3) {
                        if(genre3 != null){
                            repository.updateGenre3(null, username);
                        }

                    }
                });
                repository.getGenre4(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String genre4) {
                        if(genre4 != null){
                            repository.updateGenre4(null, username);
                        }

                    }
                });
                repository.getGenre5(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String genre5) {
                        if(genre5 != null){
                            repository.updateGenre5(null, username);
                        }

                    }
                });
            }



        });

    }




    public void  displayPlaylist() {
        int userid = getIntent().getIntExtra(BROWSE_ARTISTS_KEY, 0);
        LiveData<String> username = repository.getUserNameByUserId(userid);
        username.observe(User_Playlist_Page.this, new Observer<String>() {
            @Override
            public void onChanged(String username) {
                repository.getArtist1(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        TextView Artist1 = findViewById(R.id.Artist1);
                        Artist1.setText(s);
                        binding.Artist1.setText(s);

                    }
                });

                repository.getArtist2(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        TextView Artist2 = findViewById(R.id.Artist2);
                        Artist2.setText(s);


                    }
                });

                repository.getArtist3(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        TextView Artist3 = findViewById(R.id.Artist3);
                        Artist3.setText(s);


                    }
                });

                repository.getArtist4(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        TextView Artist4 = findViewById(R.id.Artist4);
                        Artist4.setText(s);


                    }
                });

                repository.getArtist5(username).observe(User_Playlist_Page.this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        TextView Artist5 = findViewById(R.id.Artist5);
                        Artist5.setText(s);


                    }
                });


            }
        });


    }




}