package com.itacademy.presentation.presentation.screens.homework3;

import android.arch.lifecycle.ViewModelProviders;

import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.databinding.ActivityHomework3Binding;


public class HomeWork3Activity extends BaseMvvmActivity<ActivityHomework3Binding, HW3ViewModel>{

    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework3;
    }

    @Override
    public HW3ViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(HW3ViewModel.class);
    }
}
