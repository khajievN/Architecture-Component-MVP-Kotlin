package com.nizzle94.domain.base

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nizzle94.domain.executor.PostExecutionThread
import com.nizzle94.domain.executor.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.CompletableOnSubscribe
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AbsRxCompletableUseCaseTest {

    private val threadExecutor: ThreadExecutor = mock()

    private val postExecutionThread: PostExecutionThread = mock()

    private lateinit var observer: DisposableCompletableObserverTest

    private lateinit var absRxCompletableUseCase: AbsRxCompletableUseCase<Params>

    @Before
    fun setUp() {
        given(threadExecutor.getScheduler()).willReturn(TestScheduler())
        given(postExecutionThread.getScheduler()).willReturn(TestScheduler())
        absRxCompletableUseCase = AbsRxCompletableUseCaseTestClass(threadExecutor.getScheduler(), postExecutionThread.getScheduler())
        observer = DisposableCompletableObserverTest()
    }

    @Test
    fun disposeObserver() {
        absRxCompletableUseCase.execute(observer, Params.EMPTY)
        absRxCompletableUseCase.dispose()

        assertEquals(observer.isDisposed, true)
    }

    private class AbsRxCompletableUseCaseTestClass(thread: Scheduler,
                                                   postExecutionThread: Scheduler)
        : AbsRxCompletableUseCase<Params>(thread, postExecutionThread) {

        override fun createCompletable(params: Params): Completable = Completable.create(CompletableOnSubscribe { })
    }

    class DisposableCompletableObserverTest : DefaultCompletableObserver()

    private class Params private constructor() {
        companion object {
            val EMPTY = Params()
        }
    }

}
