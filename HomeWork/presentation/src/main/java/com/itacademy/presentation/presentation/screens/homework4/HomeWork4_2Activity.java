package com.itacademy.presentation.presentation.screens.homework4;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.base.BaseViewModel;


public class HomeWork4_2Activity extends BaseMvvmActivity {
    private ImageView owl;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework4_2;
    }

    @Override
    public BaseViewModel provideViewModel() {
        return new HomeWork4_2ViewModel();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4_2);
        owl = findViewById(R.id.image_owl);
        owl.setBackgroundResource(R.drawable.owl_animation);
        // получаем объект анимации
        AnimationDrawable frameAnimation = (AnimationDrawable) owl.getBackground();
        frameAnimation.setOneShot(false);
        // запуск анимации
        frameAnimation.start();
    }

}
