package com.itacademy.presentation.presentation.screens.homework10_2;

import android.arch.lifecycle.ViewModelProviders;

import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.base.BaseViewModel;

public class HomeWork10_2Activity extends BaseMvvmActivity {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework10_2;
    }

    @Override
    public BaseViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(AddUserViewModel.class);
    }

}