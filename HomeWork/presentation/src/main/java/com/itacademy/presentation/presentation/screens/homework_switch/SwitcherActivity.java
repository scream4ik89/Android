package com.itacademy.presentation.presentation.screens.homework_switch;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.base.BaseViewModel;
import com.itacademy.presentation.databinding.ActivitySwitchBinding;
import com.itacademy.presentation.presentation.screens.homework1.HomeWork1Activity;
import com.itacademy.presentation.presentation.screens.homework10.HomeWork10Activity;
import com.itacademy.presentation.presentation.screens.homework10_1.HomeWork10_1Activity;
import com.itacademy.presentation.presentation.screens.homework10_2.HomeWork10_2Activity;
import com.itacademy.presentation.presentation.screens.homework2.HomeWork2Activity;
import com.itacademy.presentation.presentation.screens.homework3.HomeWork3Activity;
import com.itacademy.presentation.presentation.screens.homework4.HomeWork4Activity;
import com.itacademy.presentation.presentation.screens.homework5.HomeWork5Activity;
import com.itacademy.presentation.presentation.screens.homework6.HomeWork6Activity;
import com.itacademy.presentation.presentation.screens.homework7.HomeWork7Activity;
import com.itacademy.presentation.presentation.screens.homework8.HomeWork8Activity;
import com.itacademy.presentation.presentation.screens.homework9.HomeWork9Activity;

public class SwitcherActivity extends BaseMvvmActivity<ActivitySwitchBinding, BaseViewModel> implements View.OnClickListener {


    @Override
    public int provideLayoutId() {
        return R.layout.activity_switch;
    }

    @Override
    public BaseViewModel provideViewModel() {
        return new SwitcherViewModel();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);

        binding.dz1.setOnClickListener(this);
        binding.dz2.setOnClickListener(this);
        binding.dz3.setOnClickListener(this);
        binding.dz4.setOnClickListener(this);
        binding.dz5.setOnClickListener(this);
        binding.dz6.setOnClickListener(this);
        binding.dz7.setOnClickListener(this);
        binding.dz8.setOnClickListener(this);
        binding.dz9.setOnClickListener(this);
        binding.dz10.setOnClickListener(this);
        binding.dz11.setOnClickListener(this);
        binding.dz12.setOnClickListener(this);
        binding.dz13.setOnClickListener(this);

    }
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.dz1:
                    intent = new Intent(this, HomeWork1Activity.class);
                    startActivity(intent);
                   // overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
                    break;
                case R.id.dz2:
                    intent = new Intent(this, HomeWork2Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz3:
                    intent = new Intent(this, HomeWork3Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz4:
                    intent = new Intent(this, HomeWork4Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz5:
                    intent = new Intent(this, HomeWork5Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz6:
                    intent = new Intent(this, HomeWork6Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz7:
                    intent = new Intent(this, HomeWork7Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz8:
                    intent = new Intent(this, HomeWork8Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz9:
                    intent = new Intent(this, HomeWork9Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz10:
                    intent = new Intent(this, HomeWork10Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz11:
                    intent = new Intent(this, HomeWork10_1Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz12:
                    intent = new Intent(this, HomeWork10_2Activity.class);
                    startActivity(intent);
                    break;
                case R.id.dz13:
                    intent = new Intent(this, HomeWork10_2Activity.class);
                    startActivity(intent);
                    break;

            }
        }
    }
