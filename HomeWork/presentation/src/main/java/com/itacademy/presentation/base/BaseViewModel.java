package com.itacademy.presentation.base;


import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel{

    protected CompositeDisposable compositeDisposable = new CompositeDisposable(); // массив диспозов. для отписки всех сразу

    public BaseViewModel() {
        createInject();
    }

    public abstract void createInject();


    public void onCreate(){}

    public void onStart(){}

    public void onResume(){}

    public void onPause(){}

    public void onStop(){}

    public void onDestroy(){}

    @Override
    protected void onCleared() { //аналог onDestroy.вызывается когда уничтожается активити
        //отписываемся здесь, чтобы при наследовании отписка была автоматически
        super.onCleared();
        if (!compositeDisposable.isDisposed())
            compositeDisposable.dispose();
    }
}
