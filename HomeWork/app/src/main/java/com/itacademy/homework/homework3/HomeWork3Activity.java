package com.itacademy.homework.homework3;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.itacademy.homework.BuildConfig;
import com.itacademy.homework.R;

public class HomeWork3Activity extends AppCompatActivity{
    private Button buttonString, buttonImage;
    private ImageView imageView;
    private EditText editText;
    private String link = getResources().getString(R.string.url_dz3);
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework3);
        buttonString = findViewById(R.id.buttonString);
        buttonString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeWork3Activity.this, BuildConfig.API_ENDPOINT, Toast.LENGTH_LONG).show();

            }
        });
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
        buttonImage = findViewById(R.id.buttonImage);
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText() != null){
                    Glide.with(HomeWork3Activity.this).load
                            (editText.getText().toString())
                            .into(imageView);
                }
                else {
                    Glide.with(HomeWork3Activity.this).load
                            (link)
                            .into(imageView);
                }


            }
        });



    }
}
