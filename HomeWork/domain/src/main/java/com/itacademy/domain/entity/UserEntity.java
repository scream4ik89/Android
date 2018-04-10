package com.itacademy.domain.entity;


public class UserEntity {
    private String userName;
    private int age;
    private String profileUrl;
    private boolean gender;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public UserEntity() {
    }

    public UserEntity(String userName, int age, String profileUrl,  boolean gender) {
        this.userName = userName;
        this.age = age;
        this.profileUrl = profileUrl;
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getProfileUrl() {
        return profileUrl;
    }
}
