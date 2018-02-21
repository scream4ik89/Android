package com.itacademy.homework.homework4;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.itacademy.homework.R;



public class HomeWork4_2Activity extends AppCompatActivity {
    private ImageView owl;
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
