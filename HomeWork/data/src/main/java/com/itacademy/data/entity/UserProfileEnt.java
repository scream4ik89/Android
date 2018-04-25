package com.itacademy.data.entity;




import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "UserProfile")
public class UserProfileEnt {

    private String fullName;
    private String urlImg;
    private int age;
    private boolean sex;
    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    private String objectId;

    public UserProfileEnt(String fullName, String urlImg, int age, boolean sex, String objectId) {
        this.fullName = fullName;
        this.urlImg = urlImg;
        this.age = age;
        this.sex = sex;
        this.objectId = objectId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
