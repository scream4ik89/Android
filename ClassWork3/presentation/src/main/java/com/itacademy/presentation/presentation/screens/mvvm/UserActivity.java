package com.itacademy.presentation.presentation.screens.mvvm;

import android.Manifest;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.itacademy.presentation.databinding.ActivityUserBinding;
import com.itacademy.presentation.R;
import com.itacademy.presentation.base.BaseMvvmActivity;
import com.itacademy.presentation.presentation.utils.ImageChooser;

import java.io.File;


public class UserActivity extends BaseMvvmActivity<ActivityUserBinding, UserViewModel, UserRouter> {

    private static final String KEY_USER_ID = "KEY_USER_ID";

    private FusedLocationProviderClient fusedLocationProviderClient;

    public static void show(Activity activity, String id) {
        Intent intent = new Intent(activity, UserActivity.class);
        intent.putExtra(KEY_USER_ID, id);
        activity.startActivity(intent);
    }

    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel provideViewModel() {
        return ViewModelProviders.of(this).
                get(UserViewModel.class); //для того чтобы вызвался метод onCleared при уничтожении активит
    }

    @Override
    public UserRouter provideRouter() {
        return new UserRouter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(viewModel.userAdapter);

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //устанавливаем картинку для бургера
        toolbar.setNavigationIcon(R.drawable.ic_view_headline_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка нажатия для "бургера"(меню в тулбаре)
                ImageChooser.getCameraFile(UserActivity.this);
            }
        });

        //геолокация
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                Log.e("AAA", "AAA " + location.getLatitude());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            super.onActivityResult(requestCode, resultCode, data);
            File file = ImageChooser.getImageFromResult(this, requestCode, resultCode, data);
            if (file != null){
                Log.e("AAAA", "AAAA file " + file.getAbsolutePath());
            }
            else {
                Log.e("AAAA", "AAAA no file");
                String phot = file.getAbsolutePath();
                //закидываем в активити в putExtra и
                // указываем переменную для доступа в другом активити
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optional_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
