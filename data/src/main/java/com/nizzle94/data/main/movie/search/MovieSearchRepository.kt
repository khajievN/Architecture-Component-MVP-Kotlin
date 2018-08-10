package com.nizzle94.data.main.movie.search

import com.nizzle94.data.reponse.MoviesResponse
import io.reactivex.Single

/**
 * Created by Khajiev Nizomjon on 25/06/2018.
 */
interface MovieSearchRepository {

    fun getMovieListByQuery(keyword: String): Single<MoviesResponse>

}