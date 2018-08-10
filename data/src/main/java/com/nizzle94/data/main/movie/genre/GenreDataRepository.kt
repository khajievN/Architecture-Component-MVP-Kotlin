package com.nizzle94.data.main.movie.genre

import com.nizzle94.data.datasource.DataFactory
import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.data.reponse.TvListResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */

class GenreDataRepository @Inject constructor(
    private val dataFactory: DataFactory
) : GenreRepository {
    override fun getTvList(): Single<TvListResponse> {
        return dataFactory.createMoviesDataSource().getTvList()
    }

    override fun getGenreList(): Single<GenreResponse> {
        return dataFactory.createMoviesDataSource().getGenres()
    }

}