package com.itacademy.presentation.presentation.screens.homework11;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itacademy.presentation.R;
import com.itacademy.presentation.app.App;



public class HomeWork11Activity extends AppCompatActivity {

    private static final String INTRO = "intro";
    private SharedPreferences sharedPreferences;

    private TextView userName, age, avatarDescTextView, nameDescTextView, ageDescTextView;

    private ImageView imageView;
    private View backgrownd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework11);
        backgrownd = findViewById(R.id.backgrownd);
        imageView = findViewById(R.id.image_view);
        userName = findViewById(R.id.user_name);
        age = findViewById(R.id.age);
        avatarDescTextView = findViewById(R.id.avatar_desc_text_view);
        nameDescTextView = findViewById(R.id.name_desc_text_view);
        ageDescTextView = findViewById(R.id.age_desc_text_view);

        sharedPreferences = getSharedPreferences(App.APP_PREFERENCES, Context.MODE_PRIVATE);
        backgrownd.setVisibility(View.GONE);
        avatarDescTextView.setVisibility(View.GONE);
        nameDescTextView.setVisibility(View.GONE);
        ageDescTextView.setVisibility(View.GONE);
        int introCount = (sharedPreferences.getInt(INTRO, 0));
        if (introCount < 3) {
            startIntro();

        }
    }

    private void startIntro() {
        int count = sharedPreferences.getInt(INTRO, 0);
        switch (count) {
            case 0:
                backgrownd.bringToFront();
                backgrownd.setVisibility(View.VISIBLE);
                imageView.bringToFront();
                avatarDescTextView.setVisibility(View.VISIBLE);
                avatarDescTextView.bringToFront();
                nameDescTextView.setVisibility(View.GONE);
                ageDescTextView.setVisibility(View.GONE);
                break;
            case 1:
                backgrownd.bringToFront();
                backgrownd.setVisibility(View.VISIBLE);
                userName.bringToFront();
                nameDescTextView.setVisibility(View.VISIBLE);
                nameDescTextView.bringToFront();
                avatarDescTextView.setVisibility(View.GONE);
                ageDescTextView.setVisibility(View.GONE);
                break;
            case 2:
                backgrownd.bringToFront();
                backgrownd.setVisibility(View.VISIBLE);
                age.bringToFront();
                ageDescTextView.setVisibility(View.VISIBLE);
                ageDescTextView.bringToFront();
                nameDescTextView.setVisibility(View.GONE);
                avatarDescTextView.setVisibility(View.GONE);
                break;
            default:
                backgrownd.setVisibility(View.GONE);
                avatarDescTextView.setVisibility(View.GONE);
                nameDescTextView.setVisibility(View.GONE);
                ageDescTextView.setVisibility(View.GONE);
                break;
        }
        sharedPreferences.edit().putInt(INTRO, count + 1).apply();
    }
}

