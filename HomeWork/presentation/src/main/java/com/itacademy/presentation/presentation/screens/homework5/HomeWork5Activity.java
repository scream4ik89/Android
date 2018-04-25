package com.itacademy.presentation.presentation.screens.homework5;


import android.os.Bundle;
import android.support.annotation.Nullable;


import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.databinding.ActivityHomework5Binding;


public class HomeWork5Activity extends BaseMvvmActivity<ActivityHomework5Binding, HW5ViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework5;
    }

    @Override
    public HW5ViewModel provideViewModel() {
        return new HW5ViewModel();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setContext(this);
    }

}
