package com.itacademy.data.rest;


import com.itacademy.data.entity.Erorr;
import com.itacademy.data.entity.UserProfileEnt;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Path;

@Singleton
public class RestService {

    private ErrorTransformers errorTransformers;
    private RestApi restAPI;//исп паттерн композиция(могли и сразу реализовать интерфейс)

    @Inject
    public RestService(RestApi restAPI, ErrorTransformers errorTransformers) {
        this.restAPI = restAPI;
        this.errorTransformers = errorTransformers;
    }


    public Observable<List<UserProfileEnt>> loadUsers() {
        return restAPI.loadUsers()
                .compose(errorTransformers.<List<UserProfileEnt>, Erorr> parseHttpError());
    }


    public Observable<UserProfileEnt> loadUserById(@Path("id") String id) {
        return restAPI.loadUserById(id)
                .compose(errorTransformers.<UserProfileEnt, Erorr> parseHttpError());
    }

    public Completable save(UserProfileEnt ent) {
        return restAPI.save(ent);
    }

    public Completable addNewUser(UserProfileEnt ent) {
        return restAPI.addUser(ent);
    }

    public Completable remove(String id) {
        return restAPI.removeUser(id);
    }
}
