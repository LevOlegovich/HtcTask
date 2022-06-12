package com.nlv2022.htctask.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.nlv2022.htctask.pojo.Employee;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {

    @TypeConverter
    public String listSkillsToString(String[] skills) {
        return new Gson().toJson(skills);
    }

    @TypeConverter
    public String[] stringSkillsToList(String skillsAsString) {
        Gson gson = new Gson();
        String[] objects = gson.fromJson(skillsAsString, String[].class);
        String[] skills = new String[objects.length];

        for (int i = 0; i < skills.length; i++) {
            skills[i] = objects[i];

        }
        return skills;
    }

}
