package com.nizzle94.data.datasource

import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.data.reponse.MovieDetailResponse
import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.data.reponse.TvListResponse
import io.reactivex.Single

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
interface MoviesDataStore {

    fun getGenres(): Single<GenreResponse>

    fun getMoviesByGenre(genreId: Int): Single<MoviesResponse>

    fun getMovieDetail(movieId: Int): Single<MovieDetailResponse>

    fun getMovieListByQuery(keyword: String): Single<MoviesResponse>

    fun getTvList(): Single<TvListResponse>
}