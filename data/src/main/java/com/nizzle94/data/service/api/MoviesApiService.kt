package com.nizzle94.data.service.api

import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.data.reponse.MovieDetailResponse
import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.data.reponse.TvListResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */

class MoviesApiService @Inject constructor(private val endpoint: MoviesEndpoint) :
    MoviesEndpoint {
    override fun getTvList(): Single<TvListResponse> {
        return endpoint.getTvList()
    }

    override fun getMovieListByQuery(keyword: String): Single<MoviesResponse> {
        return endpoint.getMovieListByQuery(keyword)
    }

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