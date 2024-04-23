package com.example.project2_sound_wave.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project2_sound_wave.database.SoundWaveDatabase;

import java.util.Objects;

@Entity(tableName = SoundWaveDatabase.SOUND_WAVE_TABLE)
public class SoundWave {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String artist;
    private String genre;


    public SoundWave(String artist, String genre) {
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoundWave soundWave = (SoundWave) o;
        return id == soundWave.id && Objects.equals(artist, soundWave.artist) && Objects.equals(genre, soundWave.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist, genre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
