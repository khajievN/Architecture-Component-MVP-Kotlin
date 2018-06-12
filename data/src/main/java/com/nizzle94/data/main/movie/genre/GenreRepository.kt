package com.nizzle94.data.main.movie.genre

import com.nizzle94.data.main.movie.genre.GenreResponse
import io.reactivex.Single

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
interface GenreRepository {
    fun getGenreList(): Single<GenreResponse>
}