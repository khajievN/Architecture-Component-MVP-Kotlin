package com.nizzle94.architecturecomponentmvp.ui.main.movie_detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelFactory
import com.nizzle94.data.main.movie.movie_detail.MovieDetailResponse
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
class MovieDetailPresenter
@Inject constructor (private var movieDetailViewModel: MovieDetailViewModel,
                     private val viewModelFactory: ViewModelFactory) : BasePresenter<MovieDetailView>() {

    override fun disposeSubscriptions() {
    }

    fun init(fragment: Fragment, movieId: Int) {
        movieDetailViewModel = ViewModelProviders.of(fragment, viewModelFactory).get(MovieDetailViewModel::class.java)

        getView()?.showLoading()
        movieDetailViewModel.getMovieDetailLive(movieId)?.observe(fragment, Observer<MovieDetailResponse> {
            getView()?.showMovieDetail(it!!)
        })
    }

}