package com.nizzle94.architecturecomponentmvp.ui.main.di

import com.nizzle94.architecturecomponentmvp.di.scope.PerActivity
import com.nizzle94.architecturecomponentmvp.ui.main.MainPresenter
import com.nizzle94.architecturecomponentmvp.ui.main.MainViewModel
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenrePresenter
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenreViewModel
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


    @Provides
    @PerActivity
    fun providesGenrePresenter(genreViewModel: GenreViewModel): GenrePresenter =
            GenrePresenter(genreViewModel)



}
