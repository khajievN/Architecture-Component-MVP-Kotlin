package com.nizzle94.data.main.movie.movies

import com.nizzle94.data.MoviesEndpoint
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
class MoviesRepository @Inject constructor(private val moviesEndpoint: MoviesEndpoint) {

    fun getMoviesList(genreId: Int) = moviesEndpoint.getMoviesByGenre(genreId)
}