package com.example.project2_sound_wave.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.database.entities.SoundWave;

import java.util.List;

@Dao
public interface SoundWaveDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SoundWave... soundWave);

    @Delete
    void delete(SoundWave soundWave);

    @Query("Select * from " + SoundWaveDatabase.SOUND_WAVE_TABLE)
    List<SoundWave> getAllRecords();

    @Query("DELETE from " + SoundWaveDatabase.SOUND_WAVE_TABLE)
    void deleteAll();

}