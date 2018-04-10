package com.itacademy.presentation.presentation.screens.mvvm.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.itacademy.domain.entity.UserEntity;
import com.itacademy.presentation.base.BaseItemViewHolder;
import com.itacademy.presentation.databinding.ItemUserBinding;


public class UserItemViewHolder
        extends BaseItemViewHolder<UserEntity,
        UserItemViewModel, ItemUserBinding> {

    public UserItemViewHolder(ItemUserBinding binding, UserItemViewModel userItemViewModel) {
        super(binding, userItemViewModel);
    }

    public static UserItemViewHolder create(ViewGroup parent,  UserItemViewModel viewModel){

            ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()),
                    parent, false);

            return new UserItemViewHolder(binding, viewModel);
    }
}
