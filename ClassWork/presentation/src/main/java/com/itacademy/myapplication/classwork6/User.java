package com.itacademy.myapplication.classwork6;



public class User {
    private String imageUrl;
    private String name;
    private String surname;
    private String link = "https://st03.kakprosto.ru/tumb/340/images/article/2011/9/10/1_525504a2e3a47525504a2e3a86.jpg";

    public User(String imageUrl, String name, String surname) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.surname = surname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
