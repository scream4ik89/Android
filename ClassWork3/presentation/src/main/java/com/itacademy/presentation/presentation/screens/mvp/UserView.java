package com.itacademy.presentation.presentation.screens.mvp;

import com.itacademy.domain.entity.UserEntity;
import com.itacademy.presentation.base.mvp.BaseView;

public interface UserView extends BaseView {

    void showUser(UserEntity userEntity);

    //здесь можно реализовать аналог роутера
}
