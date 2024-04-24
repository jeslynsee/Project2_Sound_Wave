package com.example.project2_sound_wave.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.database.entities.User;

import java.util.List;

@Dao
public interface PlaylistDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Playlist ... playlists);

    @Delete
    void delete(Playlist playlist);

    @Query("SELECT * FROM " + SoundWaveDatabase.USER_TABLE + " ORDER BY username")
    LiveData<List<Playlist>> getAllPlaylists();
}
