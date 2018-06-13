package com.nizzle94.architecturecomponentmvp.ui.main.di

import com.nizzle94.architecturecomponentmvp.di.module.CacheModule
import com.nizzle94.architecturecomponentmvp.di.scope.PerActivity
import com.nizzle94.architecturecomponentmvp.ui.main.MainActivity
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenreFragment
import com.nizzle94.architecturecomponentmvp.ui.main.movie_detail.MovieDetailFragment
import com.nizzle94.architecturecomponentmvp.ui.main.movies.MoviesFragment
import dagger.Subcomponent

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@PerActivity
@Subcomponent(
    modules = [MainModule::class]
)
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(genreFragment: GenreFragment)

    fun inject(moviesFragment: MoviesFragment)

    fun inject(movieDetailFragment: MovieDetailFragment)

    @Subcomponent.Builder
    interface Builder {
        fun mainModule(module: MainModule): Builder
        fun build(): MainComponent
    }

}