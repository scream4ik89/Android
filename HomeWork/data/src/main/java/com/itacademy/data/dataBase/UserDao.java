package com.itacademy.data.dataBase;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.itacademy.data.entity.UserProfileEnt;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UserDao {
    String QUERY_GET_ALL = "SELECT * FROM UserProfile";
    String QUERY_GET_BU_ID = "SELECT * FROM UserProfile WHERE id = :id LIMIT 1";
    String QUERY_DELETE_ALL = "DELETE FROM UserProfile";

    @Insert
    void insert(List<UserProfileEnt> users);

    @Query(QUERY_GET_ALL)
    Flowable<List<UserProfileEnt>> getAll();

    @Query(QUERY_GET_BU_ID)
    Flowable<List<UserProfileEnt>> getById(String id);

    @Query(QUERY_DELETE_ALL)
//удалить все данные из таблицы User
    void deleteAll();

}
