package com.nizzle94.architecturecomponentmvp.ui.main.movie_detail

import android.arch.lifecycle.LifecycleOwner
import com.nizzle94.data.main.movie.movie_detail.MovieDetailResponse
import com.nizzle94.mvp.BaseView

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
interface MovieDetailView : LifecycleOwner,BaseView {

    fun showLoading()

    fun showMovieDetail(movieDetailResponse: MovieDetailResponse)

}