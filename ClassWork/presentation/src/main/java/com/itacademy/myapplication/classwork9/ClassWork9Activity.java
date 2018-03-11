package com.itacademy.myapplication.classwork9;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.itacademy.myapplication.R;
import com.itacademy.myapplication.databinding.ActivityClasswork91Binding;


public class ClassWork9Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_classwork9_1);
        MyEntitty myEntitty = new MyEntitty("Ура работает", "Какая-то кнопка");
        ActivityClasswork91Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_classwork9_1);
        binding.setMyEntity(myEntitty);

    }
}
