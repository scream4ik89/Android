package com.itacademy.presentation.presentation.screens.homework10;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.databinding.ActivityHomework10Binding;
import com.itacademy.presentation.presentation.screens.homework10.rvAdapter.AdaptRV;
import com.itacademy.presentation.presentation.screens.homework10_1.HomeWork10_1Activity;

public class HomeWork10Activity extends BaseMvvmActivity<ActivityHomework10Binding, UserProfileViewModel>
        implements AdaptRV.OnClickListener {

    private AdaptRV adaptRV;
    public static String id = "";

    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework10;
    }

    @Override
    public UserProfileViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserProfileViewModel.class);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adaptRV = new AdaptRV();
        adaptRV.setListener(this);
        RecyclerView recyclerView = binding.recyclePR;
        recyclerView.setAdapter(adaptRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onClick(String id) {
        HomeWork10Activity.id = id;
        startActivity(new Intent(this, HomeWork10_1Activity.class));
    }
}

