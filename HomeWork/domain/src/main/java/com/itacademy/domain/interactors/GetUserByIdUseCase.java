package com.itacademy.domain.interactors;

import com.itacademy.domain.entity.UserEntity;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetUserByIdUseCase extends BaseUseCase{

    private UserRepository userRepository;

    @Inject

    public GetUserByIdUseCase(PostExecutionThread postExecutionThread,
                              UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<UserEntity> get(String id){
        return userRepository.get(id)
               //Schedulers реалицазия потоков. можно делать кастомные
                .subscribeOn(threadExecution) //в каком потоке запустить
                .observeOn(postExecutionThread);  // в каком потоке получить данные
    }
}
