package com.example.project2_sound_wave.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project2_sound_wave.database.SoundWaveDatabase;

import java.util.List;

@Entity(tableName = SoundWaveDatabase.PLAYLIST_TABLE)
public class Playlist {
    @PrimaryKey
    private int id;

    private String playlistName;
//    private List<String> artists;
//    private List<String> genres;
    //TODO: create TypeConverters for the Lists above


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}
