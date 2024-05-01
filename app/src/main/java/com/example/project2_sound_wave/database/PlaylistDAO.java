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

    @Query("UPDATE playlistTable SET artists = :artists WHERE username = :username")
    void updateArtistList(List<String> artists, String username);

    @Query("UPDATE playlistTable SET genres = :genres WHERE username = :username")
    void updateGenreList(List<String> genres, String username);

    @Query("SELECT artists FROM playlistTable WHERE username = :username")
    LiveData<List<String>> getAllArtists(String username);

    @Query("SELECT genres FROM playlistTable WHERE username = :username")
    LiveData<List<String>> getAllGenres(String username);

}
