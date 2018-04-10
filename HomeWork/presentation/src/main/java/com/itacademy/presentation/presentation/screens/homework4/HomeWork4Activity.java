package com.itacademy.presentation.presentation.screens.homework4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.databinding.ActivityHomework4Binding;
import com.itacademy.presentation.presentation.screens.homework1.HomeWork1Activity;
import com.itacademy.presentation.presentation.screens.homework2.HomeWork2Activity;


public class HomeWork4Activity extends BaseMvvmActivity<ActivityHomework4Binding, HomeWork4ViewModel> implements View.OnClickListener {


    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework4;
    }

    @Override
    public HomeWork4ViewModel provideViewModel() {
        return new HomeWork4ViewModel();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);

        binding.dz41.setOnClickListener(this);
        binding.dz42.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.dz4_1:
                intent = new Intent(this, HomeWork1Activity.class);
                startActivity(intent);
                // overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
                break;
            case R.id.dz4_2:
                intent = new Intent(this, HomeWork2Activity.class);
                startActivity(intent);
                break;

        }
    }
}
