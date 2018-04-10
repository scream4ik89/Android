package com.itacademy.data.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;



//пометка для room, в какой энтити сохранять локальные данные,
// если ее не будет, возьмется имя класса
@Entity(tableName = "User")
public class User {

    @NonNull
    @PrimaryKey//пометка главного поля
    @SerializedName("objectId")
    private String objectId;

    @ColumnInfo(name = "name") //аналог @SerializedName у библиотеки Room
    @SerializedName("username")
    private String username;

    @SerializedName("age")
    private int age;

    @SerializedName("profileUrl")
    private String profileUrl;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
