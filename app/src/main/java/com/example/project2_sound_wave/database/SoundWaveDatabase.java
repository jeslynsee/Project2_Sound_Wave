package com.example.project2_sound_wave.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.database.entities.SoundWave;
import com.example.project2_sound_wave.Login_Page;
import com.example.project2_sound_wave.database.entities.User;
import com.example.project2_sound_wave.database.typeConverters.ListTypeConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TypeConverters(ListTypeConverter.class)
@Database(entities = {SoundWave.class, User.class, Playlist.class}, version = 1, exportSchema = false)
public abstract class SoundWaveDatabase extends RoomDatabase {
    public static final String USER_TABLE = "usertable";
    private static final String DATABASE_NAME = "SoundWavedatabase";
    public static final String SOUND_WAVE_TABLE = "soundWaveTable";
    public static final String PLAYLIST_TABLE = "playlistTable";

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
            Log.i(Login_Page.TAG, "DATABASE CREATED!");
            databaseWriteExecutor.execute(() -> {
                UserDAO dao = INSTANCE.userDAO();
                dao.deleteAll();
                User admin = new User("admin2", "admin2");
                admin.setAdmin(true);
                dao.insert(admin);
                User testUser1 = new User("testuser1", "testuser1");
                dao.insert(testUser1);


            });
        }
    };


    public abstract SoundWaveDAO soundWaveDAO();

    public abstract UserDAO userDAO();

    public abstract PlaylistDAO playlistDAO();
}
