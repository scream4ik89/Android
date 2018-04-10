package com.itacademy.domain.interactors;


import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.executor.ThreadExecutor;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


public abstract class BaseUseCase {
    //Executor базовоый класс по потокам. Schedulers наследуется от него
    protected Scheduler postExecutionThread;
    // поток в которм будем получать результаты в presentation слое

    protected Scheduler threadExecution;
    // поток в котором будем выполнять все сложные запросы(другой поток, не UI)

    public BaseUseCase(PostExecutionThread postExecutionThread) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.io();
    }

    public BaseUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecution) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.from(threadExecution);
    }
}
