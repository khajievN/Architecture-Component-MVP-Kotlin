package com.nizzle94.domain.base

import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class AbsRxCompletableUseCase<Params> protected constructor(
        private val threadExecutor: Scheduler,
        private val postExecutionThread: Scheduler) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    internal abstract fun createCompletable(params: Params): Completable

    fun execute(observer: DefaultCompletableObserver, params: Params) {
        addDisposable(this.createCompletable(params)
                .subscribeOn(threadExecutor)
                .observeOn(postExecutionThread)
                .subscribeWith(observer))
    }

    internal fun execute(params: Params): Completable {
        return createCompletable(params)
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

}
