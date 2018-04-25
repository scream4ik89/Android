package com.itacademy.presentation.presentation.screens.homework3;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.itacademy.data.repository.ImageUrlRepositoryImpl;
import com.itacademy.domain.entity.ImageUrl.ImageUrl;
import com.itacademy.domain.interactors.GetImageUrlUseCase;
import com.itacademy.presentation.base.BaseViewModel;
import com.itacademy.presentation.executor.UIThread;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class HW3ViewModel extends BaseViewModel {

    private GetImageUrlUseCase getImageUrlUseCase = new GetImageUrlUseCase(new UIThread(), new ImageUrlRepositoryImpl());

    public final ObservableField<String> url = new ObservableField<>();
    public final ObservableField<String> userUrl = new ObservableField<>();
    public final ObservableBoolean progress = new ObservableBoolean(true);

    public void onClick() {
        progress.set(false);
        getImageUrlUseCase.getImageUrl()
                .subscribe(new Observer<ImageUrl>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ImageUrl userEntity) {
                        url.set(userEntity.getImgUrl());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        progress.set(true);
                    }
                });
    }


    @Override
    public void createInject() {

    }
}
