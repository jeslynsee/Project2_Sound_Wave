package com.example.project2_sound_wave.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


import com.example.project2_sound_wave.database.SoundWaveDatabase;

import java.util.List;

@Entity(tableName = SoundWaveDatabase.PLAYLIST_TABLE)
public class Playlist {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private List<String> artists;
    private List<String> genres;
    private String username;

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
