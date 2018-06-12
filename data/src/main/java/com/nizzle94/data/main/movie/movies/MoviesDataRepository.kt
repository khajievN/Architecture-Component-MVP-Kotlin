package com.nizzle94.data.main.movie.movies

import com.nizzle94.data.datasource.DataFactory
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
class MoviesDataRepository @Inject constructor(private val dataFactory: DataFactory) :
    MoviesRepository {
    override fun getMoviesList(genreId: Int): Single<MoviesResponse> {
        return dataFactory.createMoviesDataSource().getMoviesByGenre(genreId)
    }

}