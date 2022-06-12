package com.nlv2022.htctask.api;

import com.nlv2022.htctask.pojo.ExampleRootCE;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiService {

    @GET("./5ddcd3673400005800eae483")

    Observable<ExampleRootCE> getEmployees();


}
