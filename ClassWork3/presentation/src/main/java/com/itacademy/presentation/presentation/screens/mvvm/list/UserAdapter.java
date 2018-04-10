package com.itacademy.presentation.presentation.screens.mvvm.list;


import android.view.ViewGroup;
import com.itacademy.domain.entity.UserEntity;
import com.itacademy.presentation.base.BaseAdapter;



public class UserAdapter extends BaseAdapter<UserEntity, UserItemViewModel> {

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return UserItemViewHolder.create(parent, new UserItemViewModel());
    }
}
