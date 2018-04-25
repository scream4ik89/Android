package com.itacademy.presentation.presentation.screens.homework10_1;

import android.content.Context;
import android.databinding.InverseMethod;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.Toast;

import com.itacademy.data.entity.Erorr;
import com.itacademy.data.entity.ErrorType;
import com.itacademy.domain.entity.UserProfileEntity;
import com.itacademy.domain.interactors.GetUserProfileByIdUseCase;
import com.itacademy.domain.interactors.RemoveUserUseCase;
import com.itacademy.domain.interactors.SaveProfUserUseCase;
import com.itacademy.presentation.app.App;
import com.itacademy.presentation.base.BaseViewModel;
import com.itacademy.presentation.presentation.screens.homework10.HomeWork10Activity;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserPFViewModel  extends BaseViewModel {

    private PublishContract publishContract;

    public void setPublishContract(PublishContract publishContract) {
        this.publishContract = publishContract;
    }

    public final ObservableField<String> fullName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
    public final ObservableBoolean gender = new ObservableBoolean();
    public final ObservableBoolean isVisibleView = new ObservableBoolean(false);
    private String objectId;

    @Inject
    public Context context;

    @Inject
    public GetUserProfileByIdUseCase userById;

    @Inject
    public SaveProfUserUseCase saveUser;

    @Inject
    public RemoveUserUseCase remove;

    public UserPFViewModel() {
        App.getAppComponent().inject(this);
        if (!HomeWork10Activity.id.equals("") && HomeWork10Activity.id != null) {
            userById.getUser(HomeWork10Activity.id)
                    .subscribe(new Observer<UserProfileEntity>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            compositeDisposable.add(d);
                        }

                        @Override
                        public void onNext(UserProfileEntity userProfileEntity) {
                            fullName.set(userProfileEntity.getFullName());
                            age.set(userProfileEntity.getAge());
                            gender.set(userProfileEntity.isSex());
                            objectId = userProfileEntity.getObjectId();
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
    }

    @Override
    public void createInject() {

    }

    public void edit() {
        isVisibleView.set(true);
    }

    public void save() {
        saveUser.save(new UserProfileEntity(fullName.get(), "", age.get(), gender.get(), objectId))
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(context, "User saved",
                                Toast.LENGTH_LONG).show();
                        isVisibleView.set(false);
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
                });

    }

    public void remove() {
        remove.removeUser(objectId)
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(context, "User deleted",
                                Toast.LENGTH_LONG).show();
                        publishContract.pressBack();
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
                });
    }

    @InverseMethod("convertFromString")
    public String convertFromInt(int age) {
        return String.valueOf(age);
    }

    public int convertFromString(String age) {
        if (age.length() == 0)
            return 0;
        return Integer.valueOf(age);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        context = null;
    }
}