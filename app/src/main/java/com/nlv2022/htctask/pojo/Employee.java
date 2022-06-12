package com.nlv2022.htctask.pojo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nlv2022.htctask.converters.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity(tableName = "employees")

public class Employee {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("name")
    @Expose
    private String name = "?-Unknow-?";
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber = "?-unknow-?";

    @SerializedName("skills")
    @Expose
    @TypeConverters(value = Converter.class)
    private List<String> skills = Arrays.asList(new String[]{"?-unknow-?"});


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
