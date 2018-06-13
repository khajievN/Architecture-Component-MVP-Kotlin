package com.nizzle94.data.datasource

import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.data.reponse.MovieDetailResponse
import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.data.service.api.MoviesApiService
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
class MoviesDataSource @Inject constructor(
    private val moviesApiService: MoviesApiService
) :
    MoviesDataStore {
    override fun getMovieDetail(movieId: Int): Single<MovieDetailResponse> {
        return moviesApiService.getMovieDetail(movieId)
    }

    override fun getMoviesByGenre(genreId: Int): Single<MoviesResponse> {
        return moviesApiService.getMoviesByGenre(genreId)
    }

    override fun getGenres(): Single<GenreResponse> {
        return moviesApiService.getGenreList()
    }

    private companion object {
        val GENRE_KEY = "GR"
    }


}