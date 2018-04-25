package com.itacademy.data.repository;

import com.itacademy.data.dataBase.AppDataBase;
import com.itacademy.data.dataBase.UserDao;
import com.itacademy.data.entity.UserProfileEnt;
import com.itacademy.data.rest.RestService;
import com.itacademy.domain.entity.UserProfileEntity;
import com.itacademy.domain.repository.UserProfileRepository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class UserProfieleRepositoryImpl implements UserProfileRepository {

    private RestService restService;
    private UserDao userDao;

    @Inject
    public UserProfieleRepositoryImpl(RestService restService, AppDataBase appDataBase) {
        this.restService = restService;
        this.userDao = appDataBase.getUserDao();
    }

    @Override
    public Observable<UserProfileEntity> getUser(final String id) {
        return restService
                .loadUserById(id)
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends UserProfileEnt>>() {
                    @Override
                    public ObservableSource<? extends UserProfileEnt> apply(Throwable throwable) throws Exception {
                        if (throwable instanceof IOException) {
                            return userDao
                                    .getById(id)
                                    .toObservable()
                                    .doOnNext()
                                    .map(new Function<List<UserProfileEnt>, UserProfileEnt>() {
                                        @Override
                                        public UserProfileEnt apply(List<UserProfileEnt> userProfileEnts) throws Exception {
                                            return userProfileEnts.get(1);
                                        }
                                    });
                        } else {
                            throw (Exception) throwable;
                        }
                    }
                })
                .map(new Function<UserProfileEnt, UserProfileEntity>() {
                    @Override
                    public UserProfileEntity apply(UserProfileEnt userProfileEnt) throws Exception {
                        return new UserProfileEntity(userProfileEnt.getFullName(), userProfileEnt.getUrlImg(), userProfileEnt.getAge(), userProfileEnt.isSex(), userProfileEnt.getObjectId());
                    }
                });
    }

    @Override
    public Observable<List<UserProfileEntity>> getList() {
        return restService
                .loadUsers()
                .doOnNext(new Consumer<List<UserProfileEnt>>() {
                    @Override
                    public void accept(List<UserProfileEnt> userProfileEnts) throws Exception {
                        userDao.deleteAll();
                        userDao.insert(userProfileEnts);
                    }
                })
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends List<UserProfileEnt>>>() {
                    @Override
                    public ObservableSource<? extends List<UserProfileEnt>> apply(Throwable throwable) throws Exception {
                        if (throwable instanceof IOException) {
                            return userDao
                                    .getAll().toObservable().take(1);
                        } else {
                            throw (Exception) throwable;
                        }

                    }
                })
                .map(new Function<List<UserProfileEnt>, List<UserProfileEntity>>() {
                    @Override
                    public List<UserProfileEntity> apply(List<UserProfileEnt> userProfileEnts) throws Exception {
                        List<UserProfileEntity> userProfileEntities = new ArrayList<>();
                        for (UserProfileEnt entity : userProfileEnts) {
                            userProfileEntities.add(new UserProfileEntity(entity.getFullName(), entity.getUrlImg(), entity.getAge(), entity.isSex(), entity.getObjectId()));
                        }
                        return userProfileEntities;
                    }
                });
    }

    @Override
    public Completable save(UserProfileEntity entity) {
        return restService.save(new UserProfileEnt(entity.getFullName(), entity.getUrlImg(), entity.getAge(), entity.isSex(), entity.getObjectId()));
    }

    @Override
    public Completable addUser(UserProfileEntity entity) {
        return restService.addNewUser(new UserProfileEnt(entity.getFullName(), entity.getUrlImg(), entity.getAge(), entity.isSex(), ""));
    }

    @Override
    public Completable remove(String id) {
        return restService.remove(id);
    }
}