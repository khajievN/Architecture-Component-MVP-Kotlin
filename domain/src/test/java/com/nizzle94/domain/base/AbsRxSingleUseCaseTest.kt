package com.nizzle94.domain.base

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nizzle94.domain.executor.PostExecutionThread
import com.nizzle94.domain.executor.ThreadExecutor
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AbsRxSingleUseCaseTest {

    private val threadExecutor: ThreadExecutor = mock()

    private val postExecutionThread: PostExecutionThread = mock()

    private lateinit var observer: DisposableSingleObserverTest<Any>

    private lateinit var absRxSingleUseCase: AbsRxSingleUseCase<Any, Params>

    @Before
    fun setUp() {
        given(threadExecutor.getScheduler()).willReturn(TestScheduler())
        given(postExecutionThread.getScheduler()).willReturn(TestScheduler())
        absRxSingleUseCase = AbsRxSingleUseCaseTestClass(threadExecutor.getScheduler(), postExecutionThread.getScheduler())
        observer = DisposableSingleObserverTest()
    }

    @Test
    fun disposeObserver() {
        absRxSingleUseCase.execute(observer, Params.EMPTY)
        absRxSingleUseCase.dispose()
        assertEquals(observer.isDisposed,true)
    }

    private class AbsRxSingleUseCaseTestClass(thread: Scheduler,
                                              postExecutionThread: Scheduler)
        : AbsRxSingleUseCase<Any, Params>(thread, postExecutionThread) {

        override fun createSingle(params: Params?): Single<Any> = Single.just(Any())

    }

    class DisposableSingleObserverTest<T> : DefaultSingleObserver<T>()

    private class Params private constructor() {
        companion object {
            val EMPTY = Params()
        }
    }

}
