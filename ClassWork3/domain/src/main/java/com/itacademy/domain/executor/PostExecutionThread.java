package com.itacademy.domain.executor;

import io.reactivex.Scheduler;


public interface PostExecutionThread {
    // этот интерфейс реализуется в presentation слое
    Scheduler getScheduler();
}
