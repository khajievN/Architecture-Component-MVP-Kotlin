package com.nizzle94.architecturecomponentmvp.ui.main.di

import com.nizzle94.architecturecomponentmvp.di.module.UseCaseModule
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.architecturecomponentmvp.di.scope.PerActivity
import com.nizzle94.architecturecomponentmvp.ui.main.MainPresenter
import com.nizzle94.architecturecomponentmvp.ui.main.MainViewModel
import com.nizzle94.cleanarchitecturekotlin.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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
