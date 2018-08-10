package com.nizzle94.domain.main.movie.search

import com.nizzle94.data.main.movie.search.MovieSearchRepository
import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.domain.base.AbsRxSingleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 25/06/2018.
 */
class MovieSearchUseCase @Inject
constructor(
    private val movieSearchRepository: MovieSearchRepository,
    private val backgroundThread: Scheduler,
    private val maintThread: Scheduler
) : AbsRxSingleUseCase<MoviesResponse, String>(backgroundThread, maintThread) {
    override fun createSingle(params: String?): Single<MoviesResponse> {
        return movieSearchRepository.getMovieListByQuery(params!!)
    }

}