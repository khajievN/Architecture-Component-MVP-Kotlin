package com.nizzle94.data.main.movie.movie_detail

import com.nizzle94.data.service.MoviesEndpoint
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
interface MovieDetailRepository {

    fun getMovieDetail(movieId: Int): Single<MovieDetailResponse>
}