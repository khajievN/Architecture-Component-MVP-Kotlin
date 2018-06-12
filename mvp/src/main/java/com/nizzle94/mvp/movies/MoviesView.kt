package com.nizzle94.mvp.movies

import com.nizzle94.data.main.movie.genre.GenreResponse
import com.nizzle94.data.main.movie.movies.MoviesResponse
import com.nizzle94.mvp.BaseView

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
interface MoviesView : BaseView {

    fun loadViewModel()

    fun populateRecyclerList(moviesResponse: MoviesResponse?)

    fun initSwipeRefreshLayout()

    fun initRecyclerAdapter()

    fun showError()

    fun showProgressbar()

    fun hideProgressbar()

}