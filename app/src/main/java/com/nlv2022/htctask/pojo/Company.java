package com.nlv2022.htctask.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {

    @SerializedName("name")
    @Expose
    private String name="Unknow";

    @SerializedName("age")
    @Expose
    private String age="unknow";

    @SerializedName("competences")
    @Expose
    private List<String> competences = Arrays.asList(new String[]{"unknow"});

    @SerializedName("employees")
    @Expose
    private List<Employee> employees = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
