package com.nizzle94.data.main.movie.search

import com.nizzle94.data.datasource.DataFactory
import com.nizzle94.data.reponse.MoviesResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 25/06/2018.
 */
class MovieSearchDataRepository @Inject constructor(
    private val dataFactory: DataFactory
) : MovieSearchRepository {
    override fun getMovieListByQuery(keyword: String): Single<MoviesResponse> {
        return dataFactory.createMoviesDataSource().getMovieListByQuery(keyword)
    }

}