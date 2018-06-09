package com.nizzle94.architecturecomponentmvp.ui.main.di

import com.nizzle94.architecturecomponentmvp.di.scope.PerActivity
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelFactory
import com.nizzle94.architecturecomponentmvp.ui.main.MainPresenter
import com.nizzle94.architecturecomponentmvp.ui.main.MainViewModel
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenrePresenter
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenreViewModel
import com.nizzle94.architecturecomponentmvp.ui.main.movie_detail.MovieDetailPresenter
import com.nizzle94.architecturecomponentmvp.ui.main.movie_detail.MovieDetailViewModel
import com.nizzle94.architecturecomponentmvp.ui.main.movies.MoviesPresenter
import com.nizzle94.architecturecomponentmvp.ui.main.movies.MoviesViewModel
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
    fun providesGenrePresenter(genreViewModel: GenreViewModel, viewModelFactory: ViewModelFactory): GenrePresenter =
            GenrePresenter(genreViewModel, viewModelFactory)


    @Provides
    @PerActivity
    fun providesMoviesPresenter(moviesViewModel: MoviesViewModel, viewModelFactory: ViewModelFactory): MoviesPresenter =
            MoviesPresenter(moviesViewModel, viewModelFactory)

    @Provides
    @PerActivity
    fun providesMovieDetailPresenter(movieDetailViewModel: MovieDetailViewModel, viewModelFactory: ViewModelFactory): MovieDetailPresenter =
            MovieDetailPresenter(movieDetailViewModel, viewModelFactory)


}
