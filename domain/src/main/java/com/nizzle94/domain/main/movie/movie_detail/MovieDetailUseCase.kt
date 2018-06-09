package com.nizzle94.domain.main.movie.movie_detail

import com.nizzle94.data.main.movie.movie_detail.MovieDetailRepository
import com.nizzle94.data.main.movie.movie_detail.MovieDetailResponse
import com.nizzle94.domain.UseCase
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
) : UseCase<MovieDetailResponse, Int>(backgroundThread, mainThread) {
    override fun buildUseCaseSingle(params: Int?): Single<MovieDetailResponse> = movieDetailRepository.getMovieDetail(params!!)
}