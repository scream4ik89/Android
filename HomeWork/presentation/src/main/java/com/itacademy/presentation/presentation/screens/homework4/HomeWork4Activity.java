package com.itacademy.presentation.presentation.screens.homework4;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.databinding.ActivityHomework4Binding;
import com.itacademy.presentation.presentation.screens.homework1.HomeWork1Activity;
import com.itacademy.presentation.presentation.screens.homework2.HomeWork2Activity;


public class HomeWork4Activity extends BaseMvvmActivity<ActivityHomework4Binding,
        HomeWork4ViewModel>{

    private ImageView sovaImg1, sovaImg2;
    private AnimationDrawable animationDrawable;

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


    }

    @Override
    protected void onStart() {
        super.onStart();
        sovaImg1 = binding.getRoot().findViewById(R.id.frameSova1);
        sovaImg2 = binding.getRoot().findViewById(R.id.frameSova2);
        sovaImg1.setBackgroundResource(R.drawable.owl_animation);
        sovaImg2.setBackgroundResource(R.drawable.owl_animation);
        animationDrawable = (AnimationDrawable) sovaImg1.getBackground();
        animationDrawable.start();
        animationDrawable = (AnimationDrawable) sovaImg2.getBackground();
        animationDrawable.start();
    }

}
