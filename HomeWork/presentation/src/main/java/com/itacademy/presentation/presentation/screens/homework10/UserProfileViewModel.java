package com.itacademy.presentation.presentation.screens.homework10;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.itacademy.data.dataBase.AppDataBase;
import com.itacademy.data.entity.Erorr;
import com.itacademy.data.entity.ErrorType;
import com.itacademy.domain.entity.UserProfileEntity;
import com.itacademy.domain.interactors.GetUserProfileListUseCase;
import com.itacademy.presentation.R;
import com.itacademy.presentation.app.App;
import com.itacademy.presentation.base.BaseViewModel;
import com.itacademy.presentation.presentation.screens.homework10.rvAdapter.AdaptRV;
import com.itacademy.presentation.presentation.screens.homework10_2.HomeWork10_2Activity;

import java.net.HttpURLConnection;
import java.util.List;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public class UserProfileViewModel extends BaseViewModel {

    @Inject
    public GetUserProfileListUseCase profileListUseCase;

    @Inject
    public AppDataBase getAppDataBase;

    @Inject
    public Context context;


    public final ObservableField<List<UserProfileEntity>> users = new ObservableField<>();


    @Override
    public void onStart() {
        super.onStart();
        App.getAppComponent().inject(this);
        profileListUseCase.getListUsers()
                .subscribe(new Observer<List<UserProfileEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(List<UserProfileEntity> userProfileEntities) {
                        users.set(userProfileEntities);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("AAA", "onError");
                        if (e instanceof Erorr){
                            Erorr myError = (Erorr) e;
                            if (myError.getMyError() == ErrorType.NO_INTERNET){
                                Toast.makeText(context, "Упс, нет интернета",
                                        Toast.LENGTH_LONG).show();
                                //сообщение об ощибке
                            } else if (myError.getMyError() == ErrorType.SERVER_NOT_AVAILABLE){
                                Toast.makeText(context, "Сервер не доступен",
                                        Toast.LENGTH_LONG).show();
                                //сообщение об ощибке
                            }
                        }
                        else {

                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public UserProfileViewModel() {
        App.getAppComponent().inject(this);

    }

    @Override
    public void createInject() {

    }

    @BindingAdapter("android:entries")
    public static void setAdaptRW(RecyclerView recyclerView, ObservableField<List<UserProfileEntity>> users) {
        AdaptRV adapterRV = (AdaptRV) recyclerView.getAdapter();
        if (users.get() != null)
            adapterRV.setUsers(users.get());
    }

    public void addNewUser() {
        Intent intent = new Intent(context, HomeWork10_2Activity.class );
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        context = null;
        //при перевороте вызовется из активити и уничтожится контекст(используй роутер)
    }
}

