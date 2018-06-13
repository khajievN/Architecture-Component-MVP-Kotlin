package com.nizzle94.mvp.genres

import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.mvp.BaseView

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
interface GenresView : BaseView {

    fun loadViewModel()

    fun populateRecyclerList(genreResponse: GenreResponse?)

    fun initSwipeRefreshLayout()

    fun initRecyclerAdapter()

    fun showError()

    fun showProgressbar()

    fun hideProgressbar()

}