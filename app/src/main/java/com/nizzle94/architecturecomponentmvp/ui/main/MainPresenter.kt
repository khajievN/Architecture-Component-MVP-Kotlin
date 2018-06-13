package com.nizzle94.architecturecomponentmvp.ui.main

import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
class MainPresenter @Inject constructor(private val mainViewModel: MainViewModel) :
        BasePresenter<MainView>() {

    override fun disposeSubscriptions() {
    }




}