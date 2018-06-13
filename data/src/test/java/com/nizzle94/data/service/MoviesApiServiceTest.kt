package com.nizzle94.data.service

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.data.reponse.MovieDetailResponse
import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.data.service.api.MoviesApiService
import com.nizzle94.data.service.api.MoviesEndpoint
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */
class MoviesApiServiceTest {

    private lateinit var moviesApiService: MoviesApiService

    private val moviesEndpoint: MoviesEndpoint = mock()

    @Before
    fun setUp() {
        moviesApiService = MoviesApiService(moviesEndpoint)
    }

    @Test
    fun shouldGetGenreList() {
        val genreResponse: Single<GenreResponse> = mock()
        given(moviesEndpoint.getGenreList()).willReturn(genreResponse)

        val response = moviesApiService.getGenreList()

        verify(moviesEndpoint).getGenreList()

        assertEquals(genreResponse, response)
    }

    @Test
    fun shouldGetMoviesByGenre() {
        val movieResponse: Single<MoviesResponse> = mock()
        given(moviesEndpoint.getMoviesByGenre(any())).willReturn(movieResponse)

        val response = moviesApiService.getMoviesByGenre(any())

        verify(moviesEndpoint).getMoviesByGenre(any())

        assertEquals(movieResponse, response)
    }

    @Test
    fun shouldGetMovieDetail() {
        val movieDetailResponse: Single<MovieDetailResponse> = mock()
        given(moviesEndpoint.getMovieDetail(any())).willReturn(movieDetailResponse)

        val response = moviesApiService.getMovieDetail(any())

        verify(moviesEndpoint).getMovieDetail(any())

        assertEquals(movieDetailResponse, response)
    }

}