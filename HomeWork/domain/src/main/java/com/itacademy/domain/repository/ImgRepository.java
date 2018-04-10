package com.itacademy.domain.repository;

import com.itacademy.domain.entity.ImageUrl.ImageUrl;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface ImgRepository {
    Observable<ImageUrl> getImageUrl();

    Completable save();

    Completable remove();
}
