package com.nizzle94.architecturecomponentmvp.ui.main.di

import com.nizzle94.architecturecomponentmvp.di.scope.PerActivity
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelFactory
import com.nizzle94.architecturecomponentmvp.ui.main.MainPresenter
import com.nizzle94.architecturecomponentmvp.ui.main.MainViewModel
import com.nizzle94.architecturecomponentmvp.ui.main.movie_detail.MovieDetailViewModel
import com.nizzle94.mvp.movie_detail.MovieDetailPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@Module()
class MainModule {

    @Provides
    @PerActivity
    fun providesMainPresenter(mainViewModel: MainViewModel): MainPresenter =
            MainPresenter(mainViewModel)



}
