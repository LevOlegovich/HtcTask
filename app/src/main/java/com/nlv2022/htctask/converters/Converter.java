package com.nlv2022.htctask.converters;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.nlv2022.htctask.pojo.Employee;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
