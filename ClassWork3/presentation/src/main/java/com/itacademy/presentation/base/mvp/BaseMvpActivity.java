package com.itacademy.presentation.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.itacademy.presentation.base.Router;

public abstract class BaseMvpActivity <Presenter extends BasePresenter, Rout extends Router>
        extends AppCompatActivity implements BaseView{


    protected Presenter presenter;

    @Nullable
    protected Rout router;

    public abstract int provideLayoutId();
    public abstract Presenter providePresenter();
    public abstract Rout provideRouter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = providePresenter();
        setContentView(provideLayoutId());

        router = provideRouter();
        //attach для view и роутера
        presenter.attach(this, router);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        router = null;
        presenter.detach();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showError(Throwable throwable) {

    }
}

