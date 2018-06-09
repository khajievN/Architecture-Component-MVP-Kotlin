package com.nizzle94.architecturecomponentmvp.ui.main.movies

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelFactory
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenreView
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenreViewModel
import com.nizzle94.data.main.movie.movies.MoviesResponse
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
class MoviesPresenter @Inject constructor(private var moviesViewModel: MoviesViewModel,
                                          private val viewModelFactory: ViewModelFactory) : BasePresenter<MoviesView>() {


    fun init(fragment: Fragment,genreId: Int) {
        moviesViewModel = ViewModelProviders.of(fragment, viewModelFactory).get(MoviesViewModel::class.java)

        getView()?.showLoading()
        moviesViewModel.getListMoviesByGenre(genreId)?.observe(getView()!!, Observer<MoviesResponse> {
            getView()?.hideLoading()
            getView()?.showMoviesList(it?.movieList!!)
        })
    }

    override fun disposeSubscriptions() {
    }

}