package com.nizzle94.data.main.movie.movie_detail

import com.nizzle94.data.MoviesEndpoint
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
class MovieDetailRepository @Inject constructor(private val endpoint: MoviesEndpoint) {

    fun getMovieDetail(movieId: Int) = endpoint.getMovieDetail(movieId)
}