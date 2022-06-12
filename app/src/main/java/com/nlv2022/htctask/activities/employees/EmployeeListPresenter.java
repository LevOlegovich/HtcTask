package com.nlv2022.htctask.activities.employees;

import android.widget.Toast;

import com.nlv2022.htctask.api.ApiFactory;
import com.nlv2022.htctask.api.ApiService;
import com.nlv2022.htctask.pojo.ExampleRootCE;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

//public class EmployeeListPresenter {
//
//
//    private CompositeDisposable compositeDisposable;
//    private EmloyeesListViewI view;
//
//    public EmployeeListPresenter(EmloyeesListViewI view) {
//        this.view = view;
//    }
//
//    public void loadDate() {
//        ApiFactory apiFactory = ApiFactory.getInstance();
//        ApiService apiService = apiFactory.getApiservice();
//        compositeDisposable = new CompositeDisposable();
//        Disposable disposable = apiService.getEmployees()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<ExampleRootCE>() {
//
//                    @Override
//                    public void accept(ExampleRootCE exampleRootCE) throws Exception {
//                        view.showData(exampleRootCE.getCompany().getEmployees());
//
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                        view.showError();
//
//                    }
//                });
//
//        compositeDisposable.add(disposable);
//
//
//    }
//
//    public void disposeDisposable() {
//        if (compositeDisposable != null) {
//            compositeDisposable.dispose();
//        }
//    }
//
//}
