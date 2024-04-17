package com.example.project2_sound_wave.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.project2_sound_wave.database.entities.SoundWave;
import com.example.project2_sound_wave.MainActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {SoundWave.class}, version = 1, exportSchema = false)
public abstract class SoundWaveDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "SoundWave_database";
    public static final String SOUND_WAVE_TABLE = "soundWaveTable";

    private static volatile SoundWaveDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static SoundWaveDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SoundWaveDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            SoundWaveDatabase.class,
                                        DATABASE_NAME
                    )
                            .fallbackToDestructiveMigration()
                            .addCallback(addDefaultValues)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.i(MainActivity.TAG, "DATABASE CREATED!");
            //TODO: add databaseWriteExecutor.execute(() -> {...}
        }
    };

    public abstract SoundWaveDAO soundWaveDAO();
}
