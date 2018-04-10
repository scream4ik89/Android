package com.itacademy.presentation.presentation.screens.homework1;


import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.databinding.ActivityHomework1Binding;


public class HomeWork1Activity extends BaseMvvmActivity<ActivityHomework1Binding, HW1ViewModel>{


    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework1;
    }

    @Override
    public HW1ViewModel provideViewModel() {
        return new HW1ViewModel();
    }

}
