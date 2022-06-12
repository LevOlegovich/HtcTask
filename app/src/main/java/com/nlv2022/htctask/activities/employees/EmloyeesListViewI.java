package com.nlv2022.htctask.activities.employees;

import com.nlv2022.htctask.pojo.Employee;

import java.util.List;

public interface EmloyeesListViewI {
    void showData(List<Employee> employees);

    void showError();


}
