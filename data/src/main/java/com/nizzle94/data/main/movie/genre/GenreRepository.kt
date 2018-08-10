package com.nizzle94.data.main.movie.genre

import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.data.reponse.TvListResponse
import io.reactivex.Single

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
interface GenreRepository {
    fun getGenreList(): Single<GenreResponse>

    fun getTvList(): Single<TvListResponse>
}