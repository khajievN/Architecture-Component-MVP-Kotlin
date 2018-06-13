package com.nizzle94.data.main.movie.movies

import com.nizzle94.data.reponse.MoviesResponse
import io.reactivex.Single

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
interface MoviesRepository {

    fun getMoviesList(genreId: Int): Single<MoviesResponse>
}