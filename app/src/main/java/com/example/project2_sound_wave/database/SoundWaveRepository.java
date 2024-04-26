package com.example.project2_sound_wave.database;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.project2_sound_wave.database.entities.Playlist;
import com.example.project2_sound_wave.database.entities.SoundWave;
import com.example.project2_sound_wave.Login_Page;
import com.example.project2_sound_wave.database.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SoundWaveRepository {
    private final SoundWaveDAO soundWaveDAO;
    private final UserDAO userDAO;
    private final PlaylistDAO playlistDAO;
    private ArrayList<SoundWave> allLogs;

    private static SoundWaveRepository repository;

    public SoundWaveRepository(Application application) {
        SoundWaveDatabase db = SoundWaveDatabase.getDatabase(application);
        this.soundWaveDAO = db.soundWaveDAO();
        this.userDAO = db.userDAO();
        this.playlistDAO = db.playlistDAO();
        this.allLogs = (ArrayList<SoundWave>) this.soundWaveDAO.getAllRecords();
    }

    public static SoundWaveRepository getRepository(Application application) {
        if (repository != null) {
            return repository;
        }
        Future<SoundWaveRepository> future = SoundWaveDatabase.databaseWriteExecutor.submit(
                new Callable<SoundWaveRepository>() {
                    @Override
                    public SoundWaveRepository call() throws Exception {
                        return new SoundWaveRepository(application);
                    }
                }
        );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.d(Login_Page.TAG, "Problem getting SoundWave repository, thread error.");
        }
        return null;
    }

    public ArrayList<SoundWave> getAllLogs() {
        Future<ArrayList<SoundWave>> future = SoundWaveDatabase.databaseWriteExecutor.submit(
                new Callable<ArrayList<SoundWave>>() {
                    @Override
                    public ArrayList<SoundWave> call() throws Exception {
                        return (ArrayList<SoundWave>) soundWaveDAO.getAllRecords();
                    }
                }
        );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.i(Login_Page.TAG, "Problem getting all artist and genre info in repository");
        }
        return null;
    }



    public void insertSoundWave(SoundWave soundWave) {
        SoundWaveDatabase.databaseWriteExecutor.execute(() ->
        {
            soundWaveDAO.insert(soundWave);
        });
    }

    public void insertUser(User... user) {
        SoundWaveDatabase.databaseWriteExecutor.execute(() ->
        {
            userDAO.insert(user);
        });
    }

    public void delete(User user) {
        SoundWaveDatabase.databaseWriteExecutor.execute(() ->
        {
            userDAO.delete(user);
        });
    }

    public LiveData<User> getUserByUserName(String username) {
        return userDAO.getUserByUserName(username);
    }

    public LiveData<User> getUserByUserId(int userId) {
        return userDAO.getUserByUserId(userId);
    }


public LiveData<List<User>> getAllUsers() {
    Future<LiveData<List<User>>> future = SoundWaveDatabase.databaseWriteExecutor.submit(
            new Callable<LiveData<List<User>>>() {
                @Override
                public LiveData<List<User>> call() throws Exception {
                    return userDAO.getAllUsers();
                }
            }
    );
    try {
        return future.get();
    } catch (InterruptedException | ExecutionException e) {
        Log.i(Login_Page.TAG, "Problem getting all users in repository");
    }
    return null;
}

    public LiveData<List<String>> getAllUsernames() {
        Future<LiveData<List<String>>> future = SoundWaveDatabase.databaseWriteExecutor.submit(
                new Callable<LiveData<List<String>>>() {
                    @Override
                    public LiveData<List<String>> call() throws Exception {
                        return userDAO.getAllUsernames();
                    }
                }
        );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.i(Login_Page.TAG, "Problem getting all usernames in repository");
        }
        return null;
    }


}
