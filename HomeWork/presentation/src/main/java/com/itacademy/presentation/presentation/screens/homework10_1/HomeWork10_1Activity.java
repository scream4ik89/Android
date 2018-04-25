package com.itacademy.presentation.presentation.screens.homework10_1;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.databinding.ActivityHomework101Binding;

public class HomeWork10_1Activity extends BaseMvvmActivity<ActivityHomework101Binding, UserPFViewModel>
implements PublishContract{
    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework10_1;
    }

    @Override
    public UserPFViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserPFViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setPublishContract(this);
    }

    @Override
    public void pressBack() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}