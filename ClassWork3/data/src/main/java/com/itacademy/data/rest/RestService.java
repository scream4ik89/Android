package com.itacademy.data.rest;


import com.itacademy.data.entity.Erorr;
import com.itacademy.data.entity.User;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class RestService {

    private ErrorTransformers errorTransformers;
    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi, ErrorTransformers errorTransformers) {
        this.restApi = restApi;
        this.errorTransformers = errorTransformers;
    }

    public Observable<List<User>> loadUsers(){
        return restApi
                .loadUsers()
                .compose(errorTransformers.<List<User>, Erorr> parseHttpError());

    }

    public Observable<User> loadUserById(String id){
        return restApi
                .loadUserById(id)
                .compose(errorTransformers.<User, Erorr> parseHttpError());
    }
}
