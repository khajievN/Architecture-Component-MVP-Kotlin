package com.nizzle94.mvp.movie_detail

import com.nizzle94.data.reponse.MovieDetailResponse
import com.nizzle94.mvp.BaseView

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
interface MovieDetailView : BaseView{

    fun loadViewModel()

    fun populateView(moviesResponse: MovieDetailResponse?)

    fun showError()

    fun showProgressbar()

    fun hideProgressbar()
}