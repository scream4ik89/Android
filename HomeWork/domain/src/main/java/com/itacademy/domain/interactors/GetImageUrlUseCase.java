package com.itacademy.domain.interactors;

import com.itacademy.domain.entity.ImageUrl.ImageUrl;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.ImgRepository;

import io.reactivex.Observable;


public class GetImageUrlUseCase extends BaseUseCase {

    private ImgRepository imgRepository;

    public GetImageUrlUseCase(PostExecutionThread postExecutionThread, ImgRepository imgRepository) {
        super(postExecutionThread);
        this.imgRepository = imgRepository;
    }

    public Observable<ImageUrl> getImageUrl() {
        return imgRepository.getImageUrl()
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

}
