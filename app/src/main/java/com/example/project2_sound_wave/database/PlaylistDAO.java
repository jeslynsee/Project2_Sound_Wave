package com.example.project2_sound_wave.database;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.project2_sound_wave.database.entities.Playlist;

public interface PlaylistDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Playlist ... playlists);

    //TODO: Fully implement this
}
