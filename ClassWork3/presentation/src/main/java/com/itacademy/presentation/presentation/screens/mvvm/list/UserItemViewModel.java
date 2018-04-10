package com.itacademy.presentation.presentation.screens.mvvm.list;

import android.databinding.ObservableField;

import com.itacademy.domain.entity.UserEntity;
import com.itacademy.presentation.base.BaseItemViewModel;

public class UserItemViewModel extends BaseItemViewModel<UserEntity> {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> age = new ObservableField<>("");

    @Override
    public void setItem(UserEntity user, int position) {
        name.set(user.getUserName());
        age.set(String.valueOf(user.getAge()));

    }
}
