package com.nizzle94.architecturecomponentmvp.di.module

import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.data.Endpoint
import com.nizzle94.data.MoviesEndpoint
import com.nizzle94.data.login.LoginRepository
import com.nizzle94.data.main.movie.genre.GenreRepository
import com.nizzle94.data.main.movie.movie_detail.MovieDetailRepository
import com.nizzle94.data.main.movie.movies.MoviesRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@Module(includes = [NetModule::class])
class RepoModule {


    @Provides
    @AppScope
    fun providesLoginRepository(endpoint: Endpoint): LoginRepository {
        return LoginRepository(endpoint)
    }

    @Provides
    @AppScope
    fun providesGenreRepository(moviesEndpoint: MoviesEndpoint): GenreRepository {
        return GenreRepository(moviesEndpoint)
    }

    @Provides
    @AppScope
    fun providesMoviesRepository(moviesEndpoint: MoviesEndpoint): MoviesRepository {
        return MoviesRepository(moviesEndpoint)
    }

    @Provides
    @AppScope
    fun providesMovieDetailRepository(moviesEndpoint: MoviesEndpoint): MovieDetailRepository {
        return MovieDetailRepository(moviesEndpoint)
    }
}