package com.itacademy.data.entity;

public class Erorr extends Exception {

    private ErrorType myError;

    public Erorr(ErrorType myError) {
        this.myError = myError;
    }
    public ErrorType getMyError(){
        return myError;
    }
}
