package com.nlv2022.htctask.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Converter {

    @TypeConverter
    public String get_string(List<String> skills) {
        return new Gson().toJson(skills);

    }

    @TypeConverter
    public List<String> get_list(String skills) {
        if (skills == null)
            return null;
        return Arrays.asList
                (skills.replace("["," ")
                        .replace("]"," ").split(","));
    }


//
//    @TypeConverter
//    public List<String> toList(String skills) {
//        return Arrays.asList(skills);
//    }



}
