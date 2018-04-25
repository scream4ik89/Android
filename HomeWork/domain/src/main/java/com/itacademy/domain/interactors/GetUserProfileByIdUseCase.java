package com.itacademy.domain.interactors;

import com.itacademy.domain.entity.UserProfileEntity;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.UserProfileRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetUserProfileByIdUseCase extends BaseUseCase{

    private UserProfileRepository userProfileRepository;

    @Inject
    public GetUserProfileByIdUseCase(PostExecutionThread postExecutionThread, UserProfileRepository userProfileRepository) {
        super(postExecutionThread);
        this.userProfileRepository = userProfileRepository;
    }

    public Observable<UserProfileEntity> getUser(String id) {
        return userProfileRepository.getUser(id)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
