package com.itacademy.domain.interactors;

import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.UserProfileRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class RemoveUserUseCase extends BaseUseCase {

    private UserProfileRepository repository;

    @Inject
    public RemoveUserUseCase(PostExecutionThread postExecutionThread, UserProfileRepository repository) {
        super(postExecutionThread);
        this.repository = repository;
    }

    public Completable removeUser(String id){
        return repository.remove(id)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

}