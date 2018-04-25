package com.itacademy.domain.repository;

import com.itacademy.domain.entity.UserProfileEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface UserProfileRepository {

    Observable<UserProfileEntity> getUser(String id);

    Observable<List<UserProfileEntity>> getList();

    Completable save(UserProfileEntity entity);

    Completable addUser(UserProfileEntity entity);

    Completable remove(String id);//нужна одна информация удалили или нет
}

