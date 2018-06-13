package com.nizzle94.data.repository

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nizzle94.data.datasource.DataFactory
import com.nizzle94.data.datasource.MoviesDataStore
import com.nizzle94.data.main.movie.movie_detail.MovieDetailDataRepository
import com.nizzle94.data.reponse.MovieDetailResponse
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */
class MovieDetailDataRepositoryTest {

    private lateinit var movieDetailDataRepository: MovieDetailDataRepository

    private var dataFactory: DataFactory = mock()

    private var moviesDataStore: MoviesDataStore = mock()

    @Before
    fun setUp() {
        movieDetailDataRepository = MovieDetailDataRepository(dataFactory)
        given(dataFactory.createMoviesDataSource()).willReturn(moviesDataStore)
    }

    @Test
    fun shouldGetMovieDetail() {
        val movieDetailResponse:MovieDetailResponse = mock()
        given(movieDetailDataRepository.getMovieDetail(1)).willReturn(Single.just(movieDetailResponse))

        movieDetailDataRepository.getMovieDetail(1)
        verify(moviesDataStore).getMovieDetail(1)
    }
}