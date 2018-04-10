package com.itacademy.presentation.presentation.screens.homework9;

import android.arch.lifecycle.ViewModelProviders;

import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.databinding.ActivityUserBinding;


public class UserActivity extends BaseMvvmActivity<ActivityUserBinding, UserViewModel> {
    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel provideViewModel() {
        return ViewModelProviders.of(this).
                get(UserViewModel.class); //для того чтобы вызвался метод onCleared при уничтожении активит
    }

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //RxView.onClick(binding.View)
//
//    }
}
