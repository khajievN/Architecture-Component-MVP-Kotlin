package com.nizzle94.domain.main.movie.genre

import com.nizzle94.data.main.movie.genre.GenreResponse
import com.nizzle94.data.main.movie.genre.GenreRepository
import com.nizzle94.domain.UseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
class GenreUseCase @Inject
constructor(private val genreRepository: GenreRepository,
            private val backgroundThread: Scheduler,
            private val mainThread: Scheduler) : UseCase<GenreResponse, Unit>(backgroundThread, mainThread) {
    override fun buildUseCaseSingle(params: Unit?): Single<GenreResponse> = genreRepository.getGenreList()


}