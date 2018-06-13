package com.nizzle94.domain.usecase

import com.nhaarman.mockito_kotlin.*
import com.nizzle94.data.main.movie.genre.GenreRepository
import com.nizzle94.data.main.movie.movies.MoviesRepository
import com.nizzle94.domain.executor.PostExecutionThread
import com.nizzle94.domain.executor.ThreadExecutor
import com.nizzle94.domain.main.movie.genre.GenreUseCase
import com.nizzle94.domain.main.movie.movies.MoviesUseCase
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */
class MoviesUseCaseTest {

    private lateinit var moviesUseCase: MoviesUseCase

    private var moviesRepository: MoviesRepository = mock()

    private val threadExecutor: ThreadExecutor = mock()

    private val postExecutionThread: PostExecutionThread = mock()

    @Before
    fun setUp() {
        given(threadExecutor.getScheduler()).willReturn(TestScheduler())
        given(postExecutionThread.getScheduler()).willReturn(TestScheduler())
        moviesUseCase = MoviesUseCase(
            moviesRepository,
            threadExecutor.getScheduler(),
            postExecutionThread.getScheduler()
        )

    }

    @Test
    fun shouldGetGenres(){
        moviesUseCase.createSingle(any())
        verify(moviesRepository).getMoviesList(any())
        verifyNoMoreInteractions(moviesRepository)
//        verifyZeroInteractions(postExecutionThread)
//        verifyZeroInteractions(threadExecutor)
    }
}