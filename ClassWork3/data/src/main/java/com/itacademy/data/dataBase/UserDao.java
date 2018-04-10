package com.itacademy.data.dataBase;

//интерфейс для реализации действий библиотеки Room

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.itacademy.data.entity.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

import io.reactivex.Completable;

@Dao
public interface UserDao {

    @Insert
    void insert(List<User> userList); //указываем куда сохранять данные(база данных)

    @Query("SELECT * FROM User")
    Flowable<List<User>> getAll(); //получаем данные

    @Query("SELECT * FROM User WHERE objectId = :id LIMIT 1") //получаем данные 1 юзера
    Flowable<List<User>> getById(String id);

    @Query("DELETE FROM User") //удаление, чтобы изменения не смешивались со старыми данными
    void deleteAll();
}
