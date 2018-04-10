package com.itacademy.data.dataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.itacademy.data.entity.User;

@Database(entities = {User.class}, version = 1) //указываем версию,
// для синхранизации данных на других версиях(надо реализовывать)
public abstract class AppDataBase extends RoomDatabase{

    public abstract UserDao getUserDao(); //реализацию делает сам room
}
