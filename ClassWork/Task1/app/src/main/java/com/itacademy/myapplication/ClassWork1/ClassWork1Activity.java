package com.itacademy.myapplication.ClassWork1;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.itacademy.myapplication.BuildConfig;
import com.itacademy.myapplication.ClassWork2.ClassWork2Activity;
import com.itacademy.myapplication.R;

public class ClassWork1Activity extends AppCompatActivity {
    private static final String TAG = ClassWork1Activity.class.getSimpleName();
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork1);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ClassWork1Activity.this, ClassWork2Activity.class);
                intent.putExtra(ClassWork2Activity.KEY_TEXT, "Hellooo");
                startActivity(intent);

                //startActivity(new Intent(ClassWork1Activity.this, ClassWork2Activity.class));  сокращенный вариант интента
                //finish();//удаляет активити при возврате с другого активити
            }
        });
        button2 = findViewById(R.id.button2);
        button2.setText(BuildConfig.API_URL);

        Log.e(TAG, "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
