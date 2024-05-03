package com.example.project2_sound_wave.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.database.entities.User;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PlaylistDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Playlist ... playlists);

    @Delete
    void delete(Playlist playlist);

    @Query("SELECT * FROM " + SoundWaveDatabase.PLAYLIST_TABLE + " ORDER BY username")
    LiveData<List<Playlist>> getAllPlaylists();

    @Query("SELECT * FROM " + SoundWaveDatabase.PLAYLIST_TABLE + " WHERE username = :username")
    LiveData<Playlist> getPlaylistByUserName(String username);

    @Query("DELETE from " + SoundWaveDatabase.PLAYLIST_TABLE)
    void deleteAll();

    @Query("SELECT username FROM " + SoundWaveDatabase.PLAYLIST_TABLE)
    LiveData<List<String>> getAllUsernamesFromPlaylistTable();

    @Query("SELECT artist1 from playlistTable WHERE username = :username")
    LiveData<String> getArtist1(String username);

    @Query("SELECT artist2 from playlistTable WHERE username = :username")
    LiveData<String> getArtist2(String username);

    @Query("SELECT artist3 from playlistTable WHERE username = :username")
    LiveData<String> getArtist3(String username);

    @Query("SELECT artist4 from playlistTable WHERE username = :username")
    LiveData<String> getArtist4(String username);

    @Query("SELECT artist5 from playlistTable WHERE username = :username")
    LiveData<String> getArtist5(String username);

    @Query("SELECT genre1 from playlistTable WHERE username = :username")
    LiveData<String> getGenre1(String username);

    @Query("SELECT genre2 from playlistTable WHERE username = :username")
    LiveData<String> getGenre2(String username);

    @Query("SELECT genre3 from playlistTable WHERE username = :username")
    LiveData<String> getGenre3(String username);

    @Query("SELECT genre4 from playlistTable WHERE username = :username")
    LiveData<String> getGenre4(String username);

    @Query("SELECT genre5 from playlistTable WHERE username = :username")
    LiveData<String> getGenre5(String username);

    @Query("UPDATE playlistTable SET artist1 = :artist WHERE username = :username")
    void updateArtist1(String artist, String username);

    @Query("UPDATE playlistTable SET artist2 = :artist WHERE username = :username")
    void updateArtist2(String artist, String username);

    @Query("UPDATE playlistTable SET artist3 = :artist WHERE username = :username")
    void updateArtist3(String artist, String username);

    @Query("UPDATE playlistTable SET artist4 = :artist WHERE username = :username")
    void updateArtist4(String artist, String username);

    @Query("UPDATE playlistTable SET artist5 = :artist WHERE username = :username")
    void updateArtist5(String artist, String username);

    @Query("UPDATE playlistTable SET genre1 = :genre WHERE username = :username")
    void updateGenre1(String genre, String username);

    @Query("UPDATE playlistTable SET genre2 = :genre WHERE username = :username")
    void updateGenre2(String genre, String username);

    @Query("UPDATE playlistTable SET genre3 = :genre WHERE username = :username")
    void updateGenre3(String genre, String username);

    @Query("UPDATE playlistTable SET genre4 = :genre WHERE username = :username")
    void updateGenre4(String genre, String username);

    @Query("UPDATE playlistTable SET genre5 = :genre WHERE username = :username")
    void updateGenre5(String genre, String username);

}