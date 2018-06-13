package com.nizzle94.data.repository

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nizzle94.data.datasource.DataFactory
import com.nizzle94.data.datasource.MoviesDataStore
import com.nizzle94.data.main.movie.genre.GenreDataRepository
import com.nizzle94.data.reponse.GenreResponse
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */
class GenreDataRepositoryTest {

    private lateinit var genreDataRepository: GenreDataRepository

    private val dataFactory: DataFactory = mock()

    private val moviesDataStore: MoviesDataStore = mock()

    @Before
    fun setUp() {
        genreDataRepository = GenreDataRepository(dataFactory)
        given(dataFactory.createMoviesDataSource()).willReturn(moviesDataStore)
    }

    @Test
    fun getGenreList() {
        val genreResponse: GenreResponse = mock()
        given(genreDataRepository.getGenreList()).willReturn(Single.just(genreResponse))
        genreDataRepository.getGenreList()
        verify(moviesDataStore).getGenres()
    }

}