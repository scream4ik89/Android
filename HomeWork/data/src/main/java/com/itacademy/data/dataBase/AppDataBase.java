package com.itacademy.data.dataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.itacademy.data.entity.UserProfileEnt;

@Database(entities = {UserProfileEnt.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UserDao getUserDao();
}
