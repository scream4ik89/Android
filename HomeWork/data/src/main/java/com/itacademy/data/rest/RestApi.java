package com.itacademy.data.rest;


import com.itacademy.data.entity.UserProfileEnt;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestApi {

    @GET("data/UsersProfils")
    Observable<List<UserProfileEnt>> loadUsers();

    @GET("data/UsersProfils/{id}")
    Observable<UserProfileEnt> loadUserById(@Path("id") String id);

    @PUT("data/UsersProfils")
    Completable save(@Body UserProfileEnt ent);

    @POST("data/UsersProfils")
    Completable addUser(@Body UserProfileEnt ent);

    @DELETE("data/UsersProfils/{id}")
    Completable removeUser(@Path("id") String id);
}
