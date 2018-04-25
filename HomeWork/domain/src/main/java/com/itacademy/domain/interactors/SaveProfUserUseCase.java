package com.itacademy.domain.interactors;

import com.itacademy.domain.entity.UserProfileEntity;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.UserProfileRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class SaveProfUserUseCase extends BaseUseCase {

    private UserProfileRepository repository;

    @Inject
    public SaveProfUserUseCase(PostExecutionThread postExecutionThread, UserProfileRepository repository) {
        super(postExecutionThread);
        this.repository = repository;
    }

    public Completable save(UserProfileEntity entity) {
        return repository.save(entity)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}