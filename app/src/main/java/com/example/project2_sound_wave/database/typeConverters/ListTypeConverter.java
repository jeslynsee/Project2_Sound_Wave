package com.example.project2_sound_wave.database.typeConverters;

import androidx.room.TypeConverter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.util.List;

public class ListTypeConverter {
    @TypeConverter
    public String convertListToString(List<String> data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }

    @TypeConverter
    public List<String> convertStringtoList(String data) {
        Type listType = new TypeToken<List<String>>() {}.getType();
        return new Gson().fromJson(data, listType);
    }
}
