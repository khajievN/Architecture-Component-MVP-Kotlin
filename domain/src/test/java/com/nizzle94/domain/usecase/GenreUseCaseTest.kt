package com.nizzle94.domain.usecase

import com.nhaarman.mockito_kotlin.*
import com.nizzle94.data.main.movie.genre.GenreRepository
import com.nizzle94.domain.executor.PostExecutionThread
import com.nizzle94.domain.executor.ThreadExecutor
import com.nizzle94.domain.main.movie.genre.GenreUseCase
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */
class GenreUseCaseTest {
    private lateinit var genreUseCase: GenreUseCase

    private var genreRepository: GenreRepository = mock()

    private val threadExecutor: ThreadExecutor = mock()

    private val postExecutionThread: PostExecutionThread = mock()

    @Before
    fun setUp() {
        given(threadExecutor.getScheduler()).willReturn(TestScheduler())
        given(postExecutionThread.getScheduler()).willReturn(TestScheduler())
        genreUseCase = GenreUseCase(
            genreRepository,
            threadExecutor.getScheduler(),
            postExecutionThread.getScheduler()
        )

    }

    @Test
    fun shouldGetGenres(){
        genreUseCase.createSingle()
        verify(genreRepository).getGenreList()
        verifyNoMoreInteractions(genreRepository)
//        verifyZeroInteractions(postExecutionThread)
//        verifyZeroInteractions(threadExecutor)
    }
}