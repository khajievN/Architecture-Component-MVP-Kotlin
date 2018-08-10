package com.nizzle94.architecturecomponentmvp.ui.main

/**
 * Created by Khajiev Nizomjon on 08/06/2018.
 */
interface MainFragmentController {

    fun openMoviesByGenre(genreId: Int)

    fun openMovieDetail(movieId: Int)

    fun openMovieDetailBySearch(movieId: Int)
}