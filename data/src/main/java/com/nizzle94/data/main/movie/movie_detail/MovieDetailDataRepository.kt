package com.nizzle94.data.main.movie.movie_detail

import com.nizzle94.data.datasource.DataFactory
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
class MovieDetailDataRepository @Inject constructor(
    private val dataFactory: DataFactory
) : MovieDetailRepository {
    override fun getMovieDetail(movieId: Int): Single<MovieDetailResponse> {
        return dataFactory.createMoviesDataSource().getMovieDetail(movieId)
    }

}