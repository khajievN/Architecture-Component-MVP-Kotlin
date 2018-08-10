package com.nizzle94.architecturecomponentmvp.di.component

import android.content.Context
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.di.module.AppModule
import com.nizzle94.architecturecomponentmvp.di.module.CacheModule
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelFactory
import com.nizzle94.architecturecomponentmvp.ui.login.di.LoginComponent
import com.nizzle94.architecturecomponentmvp.ui.main.di.MainComponent
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelModule
import com.nizzle94.data.cache.CacheProvider
import com.nizzle94.data.main.movie.genre.GenreRepository
import com.nizzle94.data.main.movie.movie_detail.MovieDetailRepository
import com.nizzle94.data.main.movie.movies.MoviesRepository
import com.nizzle94.data.main.movie.search.MovieSearchRepository
import com.nizzle94.data.service.api.Endpoint
import dagger.Component
import io.rx_cache2.internal.Disk
import io.victoralbertos.jolyglot.GsonSpeaker

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@Component(modules = [AppModule::class, ViewModelModule::class, CacheModule::class])
@AppScope
interface AppComponent {

    fun inject(app: App)

    fun getApplicationContext(): Context

    fun getEndpoint(): Endpoint

    fun getViewModel(): ViewModelFactory

    fun mainBuilder(): MainComponent.Builder

    fun loginBuilder(): LoginComponent.Builder

    fun getGenreRepository(): GenreRepository

    fun getMoviesRepository(): MoviesRepository

    fun getMovieDetailRepository(): MovieDetailRepository

    fun getMovieSearchRepository(): MovieSearchRepository
}