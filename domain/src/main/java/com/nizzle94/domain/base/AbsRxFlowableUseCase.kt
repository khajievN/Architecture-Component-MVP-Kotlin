package com.nizzle94.domain.base

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.DisposableSubscriber

abstract class AbsRxFlowableUseCase<T, Params> protected constructor(
        private val threadExecutor: Scheduler,
        private val postExecutionThread: Scheduler) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    internal abstract fun createFlowable(params: Params): Flowable<T>

    fun execute(observer: DisposableSubscriber<T>, params: Params) {
        addDisposable(this.createFlowable(params)
                .subscribeOn(threadExecutor)
                .observeOn(postExecutionThread)
                .subscribeWith(observer))
    }

    internal fun execute(params: Params): Flowable<T> {
        return createFlowable(params)
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: DisposableSubscriber<T>) {
        disposables.add(disposable)
    }
}

