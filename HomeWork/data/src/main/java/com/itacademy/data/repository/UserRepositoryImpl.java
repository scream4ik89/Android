package com.itacademy.data.repository;



import com.itacademy.domain.entity.User;
import com.itacademy.domain.repository.UserRepository;



import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Observable<User> getUser() {
        //здесь создаём подписку к БД, запрос в интернет и т.д.
        Observable<User> observableUser = Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                Thread.sleep(5000);
                User entity = new User("Vasya", "Pupkin", "https://icon-icons.com/icon/Comics-Batman/97405",
                        28, true);
                emitter.onNext(entity);
                emitter.onComplete();
            }
        });
        return observableUser;
    }

    @Override
    public Completable save() {
        return null;
    }

    @Override
    public Comparable remove() {
        return null;
    }
}
