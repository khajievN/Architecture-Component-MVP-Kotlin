package com.nizzle94.domain.main.movie.movie_detail

import com.nizzle94.data.main.movie.movie_detail.MovieDetailRepository
import com.nizzle94.data.reponse.MovieDetailResponse
import com.nizzle94.domain.base.AbsRxSingleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
class MovieDetailUseCase @Inject constructor(
        private val movieDetailRepository: MovieDetailRepository,
        private val backgroundThread: Scheduler,
        private val mainThread: Scheduler
) : AbsRxSingleUseCase<MovieDetailResponse, Int>(backgroundThread, mainThread) {
    override fun createSingle(params: Int?): Single<MovieDetailResponse> {
        return movieDetailRepository.getMovieDetail(params!!)
    }

}