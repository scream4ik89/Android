package com.itacademy.domain.interactors;

import com.itacademy.domain.entity.UserProfileEntity;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.UserProfileRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class AddNewUserPFUseCase extends BaseUseCase {

    private UserProfileRepository repository;

    @Inject
    public AddNewUserPFUseCase(PostExecutionThread postExecutionThread, UserProfileRepository repository) {
        super(postExecutionThread);
        this.repository = repository;
    }

    public Completable addNewUser(UserProfileEntity entity) {
        return repository.addUser(entity)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

}
