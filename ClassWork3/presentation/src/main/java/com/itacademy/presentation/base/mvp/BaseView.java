package com.itacademy.presentation.base.mvp;

//интерфейс который вызывает методы нужные для активити
public interface BaseView {

    void showProgress();
    void dismissProgress();
    void showError(Throwable throwable);
}
