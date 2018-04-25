package com.itacademy.domain.interactors;

import com.itacademy.domain.entity.UserProfileEntity;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.UserProfileRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetUserProfileListUseCase extends BaseUseCase {

    private UserProfileRepository userProfileRepository;

    @Inject
    public GetUserProfileListUseCase(PostExecutionThread postExecutionThread, UserProfileRepository userProfileRepository) {
        super(postExecutionThread);
        this.userProfileRepository = userProfileRepository;
    }

    public Observable<List<UserProfileEntity>> getListUsers() {
        return userProfileRepository.getList()
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
