package com.nizzle94.domain

import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Khajiev Nizomjon on 10/06/2018.
 */
abstract class ObservableUseCase<T, in Params>(
    private val backgroundThread: Scheduler,
    private val mainThread: Scheduler
) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(params: Params?): Observable<T>


    fun execute(params: Params?, observer: Observer<T>) {
        val observable: Observable<T> = this.buildUseCaseObservable(params)
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