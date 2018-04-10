package com.itacademy.presentation.presentation.screens.mvvm;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.itacademy.presentation.databinding.ActivityUserBinding;
import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;


public class UserActivity extends BaseMvvmActivity<ActivityUserBinding, UserViewModel, UserRouter> {

    private static final String KEY_USER_ID = "KEY_USER_ID";

    public static void show(Activity activity, String id){
        Intent intent = new Intent(activity, UserActivity.class);
        intent.putExtra(KEY_USER_ID, id);
        activity.startActivity(intent);
    }
    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel provideViewModel() {
        return ViewModelProviders.of(this).
                get(UserViewModel.class); //для того чтобы вызвался метод onCleared при уничтожении активит
    }

    @Override
    public UserRouter provideRouter() {
        return new UserRouter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(viewModel.userAdapter);
    }
}
