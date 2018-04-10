package com.itacademy.presentation.presentation.screens.mvp;

import com.itacademy.presentation.base.mvp.BasePresenter;
import com.itacademy.presentation.presentation.screens.mvvm.list.UserAdapter;

public abstract class UserPresenter extends BasePresenter<UserView, UserRouter>{

    public abstract void onUserClick();
        //метод, который мы передаем в активити для обработки клика

    public abstract UserAdapter getUserAdapter();

}
