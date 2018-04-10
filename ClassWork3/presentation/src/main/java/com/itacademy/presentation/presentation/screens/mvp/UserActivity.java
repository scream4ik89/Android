package com.itacademy.presentation.presentation.screens.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.itacademy.domain.entity.UserEntity;
import com.itacademy.presentation.R;
import com.itacademy.presentation.base.mvp.BaseMvpActivity;


public class UserActivity extends BaseMvpActivity<UserPresenter, UserRouter>
            implements UserView{

    private static final String KEY_USER_ID = "KEY_USER_ID";

    public static void show(Activity activity, String id){
        Intent intent = new Intent(activity, UserActivity.class);
        intent.putExtra(KEY_USER_ID, id);
        activity.startActivity(intent);
    }
    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserPresenter providePresenter() {
        return new SignUserPresenter(); //делается условия для выбора
        // реализации нужной UserPresenter
    }

    @Override
    public UserRouter provideRouter() {
        return new UserRouter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //сделать findViewById() для нужных полей, чтобы их можно было заполнить в showUser
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(presenter.getUserAdapter());

        presenter.onUserClick();

    }

    @Override
    public void showUser(UserEntity userEntity) {
        //закидываем данные в xml, например в TextView
        // (нужно предварительно сделать для них findViewById())
    }
}
