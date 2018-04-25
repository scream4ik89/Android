package com.itacademy.domain.repository;


import com.itacademy.domain.entity.User;


import io.reactivex.Completable;
import io.reactivex.Observable;

public interface UserRepository {

    Observable<User> getUser();

    Completable save();

    Comparable remove();
}
