package com.example.project2_sound_wave.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


import com.example.project2_sound_wave.database.SoundWaveDatabase;
import com.example.project2_sound_wave.database.typeConverters.ListTypeConverter;

import java.util.List;

@TypeConverters(ListTypeConverter.class)
@Entity(tableName = SoundWaveDatabase.PLAYLIST_TABLE)
public class Playlist {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String artist1;
    private String artist2;
    private String artist3;
    private String artist4;
    private String artist5;

    private String genre1;
    private String genre2;
    private String genre3;
    private String genre4;
    private String genre5;

    private String username;

    public String getArtist1() {
        return artist1;
    }

    public void setArtist1(String artist1) {
        this.artist1 = artist1;
    }

    public String getArtist2() {
        return artist2;
    }

    public void setArtist2(String artist2) {
        this.artist2 = artist2;
    }

    public String getArtist3() {
        return artist3;
    }

    public void setArtist3(String artist3) {
        this.artist3 = artist3;
    }

    public String getArtist4() {
        return artist4;
    }

    public void setArtist4(String artist4) {
        this.artist4 = artist4;
    }

    public String getArtist5() {
        return artist5;
    }

    public void setArtist5(String artist5) {
        this.artist5 = artist5;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    public String getGenre4() {
        return genre4;
    }

    public void setGenre4(String genre4) {
        this.genre4 = genre4;
    }

    public String getGenre5() {
        return genre5;
    }

    public void setGenre5(String genre5) {
        this.genre5 = genre5;
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
