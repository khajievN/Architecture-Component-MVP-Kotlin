package com.nizzle94.mvp.search

import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.mvp.BaseView

/**
 * Created by Khajiev Nizomjon on 25/06/2018.
 */
interface MoviesSearchView : BaseView {

    fun loadViewModel()

    fun showProgress()

    fun hideProgress()

    fun showEmptyView()

    fun hideEmptyView()

    fun showResult(moviesResponse: MoviesResponse)

    fun initRecyclerView()

}