package com.nlv2022.htctask.data;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.nlv2022.htctask.pojo.Employee;

@Database(entities = {Employee.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "employees.db";
    private static AppDataBase dataBase;
    private static final Object LOCK = new Object();



    public static AppDataBase getInstance(Context context) {
        synchronized (LOCK) {
            if (dataBase == null) {
                dataBase = Room.databaseBuilder(context, AppDataBase.class, DATABASE_NAME)
                        .fallbackToDestructiveMigration().build();
            }
            return dataBase;

        }

    }


    public abstract EmployeeDao employeeDao();



}
