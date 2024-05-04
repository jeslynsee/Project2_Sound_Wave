package com.example.project2_sound_wave;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.database.entities.SoundWave;
import com.example.project2_sound_wave.database.entities.User;

public class UnitTests {

    Playlist playlist;
    User user;
    String artist;
    String genre;



    @Before
    public void setUp() {
        artist = "DJ Rigz";
        genre = "Rap";
        playlist = new Playlist();



    }

    @Test
    public void soundWaveInitializeTest() {
        assertNotNull(playlist);
        playlist = null;
        assertNull(playlist);
    }
    @Test
    public void getArtistTest() {
        assertEquals(playlist.getArtist1(), "DJ Rigz");
        playlist.setArtist1("J. Cole");
        assertNotEquals(playlist.getArtist1(), "DJ Rigz");
        assertEquals(playlist.getArtist1(), "J. Cole");
    }
    @Test
    public void setArtistTest() {
        assertEquals(playlist.getArtist1(), "DJ Rigz");
        playlist.setArtist1("J. Cole");
        assertNotEquals(playlist.getArtist1(), "DJ Rigz");
        assertEquals(playlist.getArtist1(), "J. Cole");
        playlist.setArtist1("AUTUMN XO");
        assertNotEquals(playlist.getArtist1(), "J. Cole");
        assertEquals(playlist.getArtist1(), "AUTUMN XO");
    }

    @Test
    public void getGenreTest() {
        assertEquals(playlist.getGenre1(), "Rap");
        assertNotEquals(playlist.getGenre1(), "Pop");
        playlist.setGenre1("Rap");
        assertNotEquals(playlist.getGenre1(), "Rap");
        assertEquals(playlist.getGenre1(), "Pop");
    }

    @Test
    public void setGenreTest() {
        assertEquals(playlist.getGenre1(), "Rap");
        playlist.setGenre1("Pop");
        assertNotEquals(playlist.getGenre1(), "Rap");
        assertEquals(playlist.getGenre1(), "Pop");
        playlist.setGenre1("Indie");
        assertNotEquals(playlist.getGenre1(), "Pop");
        assertEquals(playlist.getGenre1(), "Indie");
    }


}