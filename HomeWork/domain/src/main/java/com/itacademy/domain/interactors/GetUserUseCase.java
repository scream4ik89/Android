package com.itacademy.domain.interactors;

import com.itacademy.domain.entity.User;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetUserUseCase extends BaseUseCase{

    private UserRepository userRepository;

    @Inject

    public GetUserUseCase(PostExecutionThread postExecutionThread,
                          UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<User> getUser() {
        //здесь будут происходить необходимые преобразования прежде чем передать подписку
        //в useCase может быть только одни public класс который соответственно отвечает
        //за одну функцию(исходя из назнвания), вспомогательных классов может быть несколько
        //общение с presenter происходит через паттерн репозитори. (это удобно, и domain не
        //зависит ни от кого, т.к. любая data реализовавшая паттерн репозитори может подключиться к
        //domain(без проблем можно изменить источник даннх, напр поменять БД)
        return userRepository.getUser()
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
