package com.nizzle94.domain.main.movie.genre

import com.nizzle94.data.main.movie.genre.GenreRepository
import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.data.reponse.TvListResponse
import com.nizzle94.domain.base.AbsRxSingleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 09/08/2018.
 */
class TvListUseCase @Inject
constructor(
    private val genreRepository: GenreRepository,
    private val backgroundThread: Scheduler,
    private val mainThread: Scheduler
) : AbsRxSingleUseCase<TvListResponse, Unit>(backgroundThread, mainThread) {
    override fun createSingle(params: Unit?): Single<TvListResponse> {
        return genreRepository.getTvList()
    }

}