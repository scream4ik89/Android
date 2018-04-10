package com.itacademy.presentation.base;


import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;


import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<Rout extends Router> extends ViewModel{

    @Nullable
    protected Rout router;

    protected CompositeDisposable compositeDisposable = new CompositeDisposable(); // массив диспозов. для отписки всех сразу

    public BaseViewModel() {
        createInject();
    }

    public abstract void createInject();

    public void attachRouter(Rout router){
        this.router = router;
    }

    public void detachRouter(){
        router = null;
    }

    public void onStart(){}

    public void onResume(){}

    public void onPause(){}

    public void onStop(){}

    @Override
    protected void onCleared() { //аналог onDestroy.вызывается когда уничтожается активити
        //отписываемся здесь, чтобы при наследовании отписка была автоматически
        super.onCleared();
        if (!compositeDisposable.isDisposed())
        compositeDisposable.dispose();
    }
}
