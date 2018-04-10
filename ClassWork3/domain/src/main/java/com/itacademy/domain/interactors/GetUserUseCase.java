package com.itacademy.domain.interactors;

import com.itacademy.domain.entity.UserEntity;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetUserUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject

    public GetUserUseCase(PostExecutionThread postExecutionThread,
                              UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<List<UserEntity>> getList(){
        return userRepository.getList()
                //Schedulers реалицазия потоков. можно делать кастомные
                .subscribeOn(threadExecution) //в каком потоке запустить
                .observeOn(postExecutionThread);  // в каком потоке получить данные
    }
}
