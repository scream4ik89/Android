package com.itacademy.presentation.base.mvp;


import android.support.annotation.Nullable;

import com.itacademy.presentation.base.Router;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter <View extends BaseView, Rout extends Router>{

    @Nullable
    protected View view;
    @Nullable
    protected Rout router;

    protected CompositeDisposable compositeDisposable = new CompositeDisposable(); // массив диспозов. для отписки всех сразу

    public BasePresenter() {
        createInject();
    }

    public abstract void createInject();

    public void attach(View view, Rout router){
        this.router = router;
        this.view = view;
    }

    public void detach(){
        router = null;
        view = null;
    }

    public void onStart(){}

    public void onResume(){}

    public void onPause(){}

    public void onStop(){}

    //аналог onDestroy.вызывается когда уничтожается активити
    //отписываемся здесь, чтобы при наследовании отписка была автоматически

    public void onDestroy(){
        if (!compositeDisposable.isDisposed())
            compositeDisposable.dispose();
    }

}