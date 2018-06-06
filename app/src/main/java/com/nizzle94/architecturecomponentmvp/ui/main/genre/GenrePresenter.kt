package com.nizzle94.architecturecomponentmvp.ui.main.genre

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.Observer
import com.nizzle94.architecturecomponentmvp.ui.main.MainView
import com.nizzle94.architecturecomponentmvp.ui.main.MainViewModel
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
class GenrePresenter @Inject constructor(private val genreViewModel: GenreViewModel) :
        BasePresenter<GenreView>() {
    override fun initialise() {
        getView()?.showLoading()
        genreViewModel.genreList.observe(getView()!!, Observer<List<Genre>> {
            getView()?.hideLoading()
            getView()?.showGenreList(it!!)
        })

    }

    override fun disposeSubscriptions() {
    }


    fun getViewModel(): GenreViewModel {
        return genreViewModel
    }

}