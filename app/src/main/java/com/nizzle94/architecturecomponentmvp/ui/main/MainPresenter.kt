package com.nizzle94.architecturecomponentmvp.ui.main

import android.arch.lifecycle.Observer
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
class MainPresenter @Inject constructor(private val mainViewModel: MainViewModel) :
        BasePresenter<MainView>() {
    override fun initialise() {

    }

    override fun disposeSubscriptions() {
    }


    fun getViewModel(): MainViewModel {
        return mainViewModel
    }

}