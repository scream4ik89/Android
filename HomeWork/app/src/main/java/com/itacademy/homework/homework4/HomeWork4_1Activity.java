package com.itacademy.homework.homework4;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.itacademy.homework.R;


public class HomeWork4_1Activity extends AppCompatActivity{
    private ImageView owl;
    private Button button, button2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4_1);
        owl = findViewById(R.id.image_owl);
        button = findViewById(R.id.button_start_anim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                owl.setBackgroundResource(R.drawable.owl_animation);
                // получаем объект анимации
                AnimationDrawable frameAnimation = (AnimationDrawable) owl.getBackground();
                frameAnimation.setOneShot(false);
                // запуск анимации
                frameAnimation.start();
            }
        });
        button2 = findViewById(R.id.button_stop_anim);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationDrawable frameAnimation = (AnimationDrawable) owl.getBackground();
                frameAnimation.stop();
            }
        });
    }
}
