package com.example.project2_sound_wave.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.project2_sound_wave.database.entities.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + SoundWaveDatabase.USER_TABLE + " ORDER BY username")
    List<User> getAllUsers();

    @Query("DELETE from " + SoundWaveDatabase.USER_TABLE)
    void deleteAll();

    @Query("SELECT * FROM " + SoundWaveDatabase.USER_TABLE + " WHERE username == :username")
    User getUserByUserName(String username);
}
