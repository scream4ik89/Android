package com.itacademy.data.rest;


import com.itacademy.data.entity.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {

    @GET("data/UserTest")
    Observable<List<User>> loadUsers();

    @GET("data/UserTest/{id}")
    Observable<User> loadUserById(@Path("id") String id);
}
