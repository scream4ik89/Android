package com.itacademy.domain.repository;


import com.itacademy.domain.entity.UserEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface UserRepository {

    Observable<UserEntity> get(String id);

    Observable<List<UserEntity>> getList();

    Completable save();

}
