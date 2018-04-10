package com.itacademy.data.repository;

import com.itacademy.domain.entity.ImageUrl.ImageUrl;
import com.itacademy.domain.repository.ImgRepository;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class ImgRepositoryImpl implements ImgRepository{

    @Override
    public Observable<ImageUrl> getImageUrl() {
        return Observable.create(new ObservableOnSubscribe<ImageUrl>() {
            @Override
            public void subscribe(ObservableEmitter<ImageUrl> emitter) throws Exception {
                Thread.sleep(5000);
                emitter.onNext(new ImageUrl("https://icon-icons.com/icons2/492/PNG/512/Disney_icons_48185.png"));
                emitter.onComplete();
            }
        });
    }

    @Override
    public Completable save() {
        return null;
    }

    @Override
    public Completable remove() {
        return null;
    }
}
