package com.nizzle94.architecturecomponentmvp.ui.main.genre

import android.arch.lifecycle.*
import android.support.v4.app.Fragment
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelFactory
import com.nizzle94.architecturecomponentmvp.ui.main.MainView
import com.nizzle94.architecturecomponentmvp.ui.main.MainViewModel
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
class GenrePresenter @Inject constructor(private var genreViewModel: GenreViewModel,
                                         private var viewModelFactory: ViewModelFactory) :
        BasePresenter<GenreView>() {


    fun init(fragment: Fragment) {
        genreViewModel = ViewModelProviders.of(fragment, viewModelFactory).get(GenreViewModel::class.java)
        getView()?.showLoading()
        genreViewModel.getGenreA()?.observe(fragment, Observer<List<Genre>> {
            getView()?.hideLoading()
            getView()?.showGenreList(it!!)
        })
    }


    override fun disposeSubscriptions() {
    }


}