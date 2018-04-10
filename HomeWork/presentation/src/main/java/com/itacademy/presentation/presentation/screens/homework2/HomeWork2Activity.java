package com.itacademy.presentation.presentation.screens.homework2;


import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.databinding.ActivityHomework2Binding;

public class HomeWork2Activity extends BaseMvvmActivity<ActivityHomework2Binding, HW2ViewModel>{
    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework2;
    }

    @Override
    public HW2ViewModel provideViewModel() {
        return new HW2ViewModel();
    }
}
