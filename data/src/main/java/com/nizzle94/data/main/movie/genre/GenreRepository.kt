package com.nizzle94.data.main.movie.genre

import com.nizzle94.data.MoviesEndpoint
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
class GenreRepository @Inject constructor(private val moviesEndpoint: MoviesEndpoint) {

    fun getGenreList() = moviesEndpoint.getGenreList()

}