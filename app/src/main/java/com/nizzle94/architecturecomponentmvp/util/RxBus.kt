package com.nizzle94.architecturecomponentmvp.util

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by Khajiev Nizomjon on 06/08/2018.
 */
object RxBus {

    private val publisher = PublishSubject.create<Any>()

    fun publish(event: Any) {
        publisher.onNext(event)
    }

    // Listen should return an Observable and not the publisher
    // Using ofType we filter only events that match that class type
    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)

}