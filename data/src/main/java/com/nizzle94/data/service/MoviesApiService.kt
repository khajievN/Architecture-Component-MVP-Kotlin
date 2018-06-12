package com.nizzle94.data.service

import com.nizzle94.data.AppScope
import com.nizzle94.data.main.movie.genre.GenreResponse
import com.nizzle94.data.main.movie.movie_detail.MovieDetailResponse
import com.nizzle94.data.main.movie.movies.MoviesResponse
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */

class MoviesApiService @Inject constructor(private val endpoint: MoviesEndpoint) : MoviesEndpoint {
    override fun getGenreList(): Single<GenreResponse> {
        return endpoint.getGenreList()
    }

    override fun getMoviesByGenre(genreId: Int): Single<MoviesResponse> {
        return endpoint.getMoviesByGenre(genreId)
    }

    override fun getMovieDetail(movieId: Int): Single<MovieDetailResponse> {
        return endpoint.getMovieDetail(movieId)
    }

}