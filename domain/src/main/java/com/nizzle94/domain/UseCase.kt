package com.nizzle94.domain

import android.annotation.SuppressLint
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
abstract class UseCase<T, in Params>(
        private val backgroundThread: Scheduler,
        private val mainThread: Scheduler
) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseSingle(params: Params?): Single<T>


    @SuppressLint("CheckResult")
    fun execute(params: Params? = null, observer: SingleObserver<T>) {
        val observable: Single<T> = this.buildUseCaseSingle(params)
                .subscribeOn(backgroundThread)
                .observeOn(mainThread)
        (observable.subscribeWith(observer) as? Disposable)?.let {
            disposables.add(it)
        }
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }




}