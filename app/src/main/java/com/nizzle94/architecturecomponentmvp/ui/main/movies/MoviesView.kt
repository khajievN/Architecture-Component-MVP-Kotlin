package com.nizzle94.architecturecomponentmvp.ui.main.movies

import android.arch.lifecycle.LifecycleOwner
import com.nizzle94.data.main.movie.movies.Movie
import com.nizzle94.mvp.BaseView

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
interface MoviesView : LifecycleOwner, BaseView {

    fun showLoading()

    fun showMoviesList(moviesList: List<Movie>)

    fun hideLoading()

}