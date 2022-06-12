package com.nlv2022.htctask.activities.employees;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nlv2022.htctask.R;
import com.nlv2022.htctask.adapter.EmployeeAdapter;
import com.nlv2022.htctask.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeesActivity extends AppCompatActivity {


    private RecyclerView recyclerViewEmployees;
    private EmployeeAdapter adapter;
//    private EmployeeListPresenter presenter;

    private EmployeeViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        presenter = new EmployeeListPresenter(this);
        recyclerViewEmployees = findViewById(R.id.rcView);
        adapter = new EmployeeAdapter();
        adapter.setEmployees(new ArrayList<>());


        recyclerViewEmployees.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEmployees.setAdapter(adapter);
//        presenter.loadDate();


        viewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        viewModel.getEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {

                adapter.setEmployees(employees);
            }
        });
        viewModel.getErrors().observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                if (throwable != null) {
                    Toast.makeText(EmployeesActivity.this, "Error!!!", Toast.LENGTH_LONG).show();
                    viewModel.clearErrors();
                }
            }
        });
        viewModel.loadDate();



    }


//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
////        presenter.disposeDisposable();
//    }
//
//    @Override
//    public void showData(List<Employee> employees) {
//        adapter.setEmployees(employees);
//
//    }
//
//    @Override
//    public void showError() {
//        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
//
//    }
}