package com.nizzle94.domain.usecase

import com.nhaarman.mockito_kotlin.*
import com.nizzle94.data.main.movie.movie_detail.MovieDetailRepository
import com.nizzle94.data.main.movie.movies.MoviesRepository
import com.nizzle94.data.reponse.MovieDetailResponse
import com.nizzle94.domain.executor.PostExecutionThread
import com.nizzle94.domain.executor.ThreadExecutor
import com.nizzle94.domain.main.movie.movie_detail.MovieDetailUseCase
import com.nizzle94.domain.main.movie.movies.MoviesUseCase
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */
class MovieDetailUseCaseTest {

    private lateinit var movieDetailUseCase: MovieDetailUseCase

    private var movieDetailRepository: MovieDetailRepository = mock()

    private val threadExecutor: ThreadExecutor = mock()

    private val postExecutionThread: PostExecutionThread = mock()

    @Before
    fun setUp() {
        given(threadExecutor.getScheduler()).willReturn(TestScheduler())
        given(postExecutionThread.getScheduler()).willReturn(TestScheduler())
        movieDetailUseCase = MovieDetailUseCase(
            movieDetailRepository,
            threadExecutor.getScheduler(),
            postExecutionThread.getScheduler()
        )

    }

    @Test
    fun shouldGetGenres(){
        movieDetailUseCase.createSingle(any())
        verify(movieDetailRepository).getMovieDetail(any())
        verifyNoMoreInteractions(movieDetailRepository)
//        verifyZeroInteractions(postExecutionThread)
//        verifyZeroInteractions(threadExecutor)
    }
}