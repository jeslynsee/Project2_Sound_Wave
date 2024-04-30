package com.example.project2_sound_wave;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.project2_sound_wave.database.entities.SoundWave;
import com.example.project2_sound_wave.database.entities.User;


/**
 * author: Jeslyn See
 * abstract: testing getters and setters for User and SoundWave
 */
public class SoundWaveUnitTest {
    User user;
    String username;
    String password;

    SoundWave soundWave;
    String artist;
    String genre;

    @Before
    public void setUp() {
        username = "Batman";
        password = "batman";
        user = new User(username, password);


        artist = "Charli XCX";
        genre = "Pop";
        soundWave = new SoundWave(artist, genre);

    }

    @Test
    public void userInitializeTest() {
        assertNotNull(user);
        user = null;
        assertNull(user);
    }

    @Test
    public void getUsernameTest() {
        assertEquals(user.getUsername(), "Batman");
        user.setUsername("Superman");
        assertNotEquals(user.getUsername(), "Batman");
    }

    @Test
    public void setUsernameTest() {
        assertEquals(user.getUsername(), "Batman");
        user.setUsername("Superman");
        assertNotEquals(user.getUsername(), "Batman");
        user.setUsername("Martian");
        assertEquals(user.getUsername(), "Martian");
    }

    @Test
    public void getPasswordTest() {
        assertEquals(user.getPassword(), "batman");
        user.setUsername("password");
        assertNotEquals(user.getUsername(), "batman");
    }

    @Test
    public void setPasswordTest() {
        assertEquals(user.getPassword(), "batman");
        user.setUsername("password");
        assertNotEquals(user.getUsername(), "batman");
        user.setPassword("secret");
        assertEquals(user.getPassword(), "secret");
    }

    @Test
    public void soundWaveInitializeTest() {
        assertNotNull(soundWave);
        soundWave = null;
        assertNull(soundWave);
    }

    @Test
    public void getArtistTest() {
        assertEquals(soundWave.getArtist(), "Charli XCX");
        soundWave.setArtist("Drake");
        assertNotEquals(soundWave.getArtist(), "Charli XCX");
        assertEquals(soundWave.getArtist(), "Drake");
    }

    @Test
    public void setArtistTest() {
        assertEquals(soundWave.getArtist(), "Charli XCX");
        soundWave.setArtist("Drake");
        assertNotEquals(soundWave.getArtist(), "Charli XCX");
        assertEquals(soundWave.getArtist(), "Drake");
        soundWave.setArtist("fun.");
        assertNotEquals(soundWave.getArtist(), "Drake");
        assertEquals(soundWave.getArtist(), "fun.");
    }

    @Test
    public void getGenreTest() {
        assertEquals(soundWave.getGenre(), "Pop");
        assertNotEquals(soundWave.getGenre(), "Rap");
        soundWave.setGenre("Rap");
        assertNotEquals(soundWave.getGenre(), "Pop");
        assertEquals(soundWave.getGenre(), "Rap");
    }

    @Test
    public void setGenreTest() {
        assertEquals(soundWave.getGenre(), "Pop");
        soundWave.setGenre("Rap");
        assertNotEquals(soundWave.getGenre(), "Pop");
        assertEquals(soundWave.getGenre(), "Rap");
        soundWave.setGenre("Indie");
        assertNotEquals(soundWave.getGenre(), "Rap");
        assertEquals(soundWave.getGenre(), "Indie");
    }

    @After
    public void tearDown()  {

    }
}