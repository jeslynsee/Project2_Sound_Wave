package com.example.project2_sound_wave.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.database.entities.SoundWave;
import com.example.project2_sound_wave.Login_Page;
import com.example.project2_sound_wave.database.entities.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {SoundWave.class, User.class, Playlist.class}, version = 9, exportSchema = false)
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

                SoundWaveDAO genres = INSTANCE.soundWaveDAO();
                Log.i(Login_Page.TAG, "SoundWave DAO initialized!");
                genres.deleteAll();
                SoundWave Artist1 = new SoundWave("Tame Impala", "Alt");
                genres.insert(Artist1);
                SoundWave Artist2 = new SoundWave("Red Hot Chili Peppers", "Alt");
                genres.insert(Artist2);
                SoundWave Artist3 = new SoundWave("Gorillaz", "Alt");
                genres.insert(Artist3);
                SoundWave Artist4 = new SoundWave("Ray Charles", "Blues");
                genres.insert(Artist4);
                SoundWave Artist5 = new SoundWave("Stevie Ray Vaughan", "Blues");
                genres.insert(Artist5);
                SoundWave Artist6 = new SoundWave("B.B. King", "Blues");
                genres.insert(Artist6);
                SoundWave Artist7 = new SoundWave("Mac Miller", "Chill");
                genres.insert(Artist7);
                SoundWave Artist8 = new SoundWave("Jaden", "Chill");
                genres.insert(Artist8);
                SoundWave Artist9 = new SoundWave("AUTUMN XO", "Chill");
                genres.insert(Artist9);
                SoundWave Artist10 = new SoundWave("Vivaldi", "Classical");
                genres.insert(Artist10);
                SoundWave Artist11 = new SoundWave("Wolfgang Amadeus Mozart", "Classical");
                genres.insert(Artist11);
                SoundWave Artist12 = new SoundWave("Beethoven", "Classical");
                genres.insert(Artist12);
                SoundWave Artist13 = new SoundWave("Johnny Cash", "Country");
                genres.insert(Artist13);
                SoundWave Artist14 = new SoundWave("Taylor Swift", "Country");
                genres.insert(Artist14);
                SoundWave Artist15 = new SoundWave("Marty Robbins", "Country");
                genres.insert(Artist15);
                SoundWave Artist16 = new SoundWave("Daft Punk", "Electronic");
                genres.insert(Artist16);
                SoundWave Artist17 = new SoundWave("Skrillex", "Electronic");
                genres.insert(Artist17);
                SoundWave Artist18 = new SoundWave("Avicii", "Electronic");
                genres.insert(Artist18);
                SoundWave Artist19 = new SoundWave("Bob Dylan", "Folk");
                genres.insert(Artist19);
                SoundWave Artist20 = new SoundWave("Steve Goodman", "Folk");
                genres.insert(Artist20);
                SoundWave Artist21 = new SoundWave("Don McLean", "Folk");
                genres.insert(Artist21);
                SoundWave Artist22 = new SoundWave("Eminem", "Hip-Hop");
                genres.insert(Artist22);
                SoundWave Artist23 = new SoundWave("50 Cent", "Hip-Hop");
                genres.insert(Artist23);
                SoundWave Artist24 = new SoundWave("Kanye West", "Hip-Hop");
                genres.insert(Artist24);
                SoundWave Artist25 = new SoundWave("Imagine Dragons", "Indie");
                genres.insert(Artist25);
                SoundWave Artist26 = new SoundWave("fun.", "Indie");
                genres.insert(Artist26);
                SoundWave Artist27 = new SoundWave("Nirvana", "Indie");
                genres.insert(Artist27);
                SoundWave Artist28 = new SoundWave("Louis Armstrong", "Jazz");
                genres.insert(Artist28);
                SoundWave Artist29 = new SoundWave("Duke Ellington", "Jazz");
                genres.insert(Artist29);
                SoundWave Artist30 = new SoundWave("Frank Sinatra", "Jazz");
                genres.insert(Artist30);
                SoundWave Artist31 = new SoundWave("Vicente Fernández", "Latin");
                genres.insert(Artist31);
                SoundWave Artist32 = new SoundWave("Los Tigres del Norte", "Latin");
                genres.insert(Artist32);
                SoundWave Artist33 = new SoundWave("Pitbull", "Latin");
                genres.insert(Artist33);
                SoundWave Artist34 = new SoundWave("Guns N' Roses", "Metal");
                genres.insert(Artist34);
                SoundWave Artist35 = new SoundWave("Metallica", "Metal");
                genres.insert(Artist35);
                SoundWave Artist36 = new SoundWave("KISS", "Metal");
                genres.insert(Artist36);
                SoundWave Artist37 = new SoundWave("Luciano Pavarotti", "Opera");
                genres.insert(Artist37);
                SoundWave Artist38 = new SoundWave("Enrico Caruso", "Opera");
                genres.insert(Artist38);
                SoundWave Artist39 = new SoundWave("Jessye Norman", "Opera");
                genres.insert(Artist39);
                SoundWave Artist40 = new SoundWave("A$AP Rocky", "Psychedelic");
                genres.insert(Artist40);
                SoundWave Artist41 = new SoundWave("The Beach Boys", "Psychedelic");
                genres.insert(Artist41);
                SoundWave Artist42 = new SoundWave("Jimi Hendrix", "Psychedelic");
                genres.insert(Artist42);
                SoundWave Artist43 = new SoundWave("J. Cole", "Rap");
                genres.insert(Artist43);
                SoundWave Artist44 = new SoundWave("Kendrick Lamar", "Rap");
                genres.insert(Artist44);
                SoundWave Artist45 = new SoundWave("Drake", "Rap");
                genres.insert(Artist45);
                SoundWave Artist46 = new SoundWave("Michael Jackson", "R and B");
                genres.insert(Artist46);
                SoundWave Artist47 = new SoundWave("Chris Brown", "R and B");
                genres.insert(Artist47);
                SoundWave Artist48 = new SoundWave("Erykah Badu", "R and B");
                genres.insert(Artist48);
                SoundWave Artist49 = new SoundWave("Otis Redding", "Soul");
                genres.insert(Artist49);
                SoundWave Artist50 = new SoundWave("Stevie Wonder", "Soul");
                genres.insert(Artist50);
                SoundWave Artist51 = new SoundWave("Lauryn Hill", "Soul");
                genres.insert(Artist51);
                SoundWave Artist52 = new SoundWave("Travis Scott", "Trap");
                genres.insert(Artist52);
                SoundWave Artist53 = new SoundWave("Playboi Carti", "Trap");
                genres.insert(Artist53);
                SoundWave Artist54 = new SoundWave("Lil Yachty", "Trap");
                genres.insert(Artist54);


                PlaylistDAO playlistDAO = INSTANCE.playlistDAO();
                playlistDAO.deleteAll();

                Playlist adminPlaylist = new Playlist();
                adminPlaylist.setUsername(admin.getUsername());

                Playlist testPlaylist = new Playlist();
                testPlaylist.setUsername(testUser1.getUsername());

                playlistDAO.insert(adminPlaylist);
                playlistDAO.insert(testPlaylist);

            });
        }
    };


    public abstract SoundWaveDAO soundWaveDAO();

    public abstract UserDAO userDAO();

    public abstract PlaylistDAO playlistDAO();
}
