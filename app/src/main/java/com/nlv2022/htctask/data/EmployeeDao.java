package com.nlv2022.htctask.data;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.nlv2022.htctask.pojo.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employees")
    LiveData<List<Employee>> getAllEmployee();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmployee(List<Employee> employees);

    @Query("DELETE  FROM employees")
    void deleteAllEmployees();


}
