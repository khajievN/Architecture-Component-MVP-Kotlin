package com.nizzle94.architecturecomponentmvp.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelFactory
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
class MainPresenter @Inject constructor(private val mainViewModel: MainViewModel) :
    BasePresenter<MainView>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun initialise() {

    }

    override fun disposeSubscriptions() {

    }
}