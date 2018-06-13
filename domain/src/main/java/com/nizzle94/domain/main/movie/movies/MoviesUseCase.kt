package com.nizzle94.domain.main.movie.movies

import com.nizzle94.data.main.movie.movies.MoviesRepository
import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.domain.base.AbsRxSingleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
class MoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository,
                                        private val backgroundThread: Scheduler,
                                        private val mainThread: Scheduler) : AbsRxSingleUseCase<MoviesResponse, Int>(backgroundThread, mainThread) {
    override fun createSingle(params: Int?): Single<MoviesResponse> {
        return moviesRepository.getMoviesList(params!!)
    }

}