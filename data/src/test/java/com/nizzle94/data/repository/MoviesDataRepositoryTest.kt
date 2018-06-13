package com.nizzle94.data.repository

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nizzle94.data.datasource.DataFactory
import com.nizzle94.data.datasource.MoviesDataStore
import com.nizzle94.data.main.movie.movies.MoviesDataRepository
import com.nizzle94.data.reponse.MoviesResponse
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */

class MoviesDataRepositoryTest {
    private lateinit var moviesDataRepository: MoviesDataRepository

    private var dataFactory: DataFactory = mock()

    private var moviesDataStore: MoviesDataStore = mock()

    @Before
    fun setUp() {
        moviesDataRepository = MoviesDataRepository(dataFactory)
        given(dataFactory.createMoviesDataSource()).willReturn(moviesDataStore)
    }

    @Test
    fun shouldGetMoviesByGenres() {
        val moviesResponse: MoviesResponse = mock()
        given(moviesDataRepository.getMoviesList(3)).willReturn(Single.just(moviesResponse))

        moviesDataRepository.getMoviesList(3)
        verify(moviesDataStore).getMoviesByGenre(3)
    }
}