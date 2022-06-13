package com.nlv2022.htctask.activities.employees;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.nlv2022.htctask.api.ApiFactory;
import com.nlv2022.htctask.api.ApiService;
import com.nlv2022.htctask.data.AppDataBase;
import com.nlv2022.htctask.pojo.Employee;
import com.nlv2022.htctask.pojo.ExampleRootCE;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class EmployeeViewModel extends AndroidViewModel {

    private static AppDataBase db;
    private LiveData<List<Employee>> employees;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<Throwable> errors;


    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        db = AppDataBase.getInstance(application);
        employees = db.employeeDao().getAllEmployee();
        errors = new MutableLiveData<>();
    }


    public LiveData<List<Employee>> getEmployees() {
        return employees;
    }


    public LiveData<Throwable> getErrors() {
        return errors;
    }


    public void clearErrors(){
        errors.setValue(null);
    }

    @SuppressWarnings("unchecked")
    private void insertEmployees(List<Employee> employees) {
        new InsertEmployeesTask().execute(employees);

    }

    private static class InsertEmployeesTask
            extends AsyncTask<List<Employee>, Void, Void> {

        @SafeVarargs
        @Override
        protected final Void doInBackground(List<Employee>... lists) {
            if (lists != null && lists.length > 0) {
                db.employeeDao().insertEmployee(lists[0]);
            }
            return null;
        }

    }


    private void deleteAllEmployees() {
        new DeleteAllEmployeeTask().execute();

    }

    private static class DeleteAllEmployeeTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            db.employeeDao().deleteAllEmployees();
            return null;
        }
    }


    public void loadDate() {
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiservice();
        compositeDisposable = new CompositeDisposable();
        Disposable disposable = apiService.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExampleRootCE>() {

                    @Override
                    public void accept(ExampleRootCE exampleRootCE) throws Exception {
                        deleteAllEmployees();
                        insertEmployees(exampleRootCE.getCompany().getEmployees());
                        Toast.makeText(getApplication().getApplicationContext(), "Данные загружены", Toast.LENGTH_LONG).show();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        errors.setValue(throwable);
                        Toast.makeText(getApplication().getApplicationContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

        compositeDisposable.add(disposable);


    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }




}
