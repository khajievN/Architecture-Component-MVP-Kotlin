package com.nizzle94.architecturecomponentmvp.di.module

import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.data.service.api.Endpoint
import com.nizzle94.data.login.LoginRepository
import com.nizzle94.data.main.movie.genre.GenreDataRepository
import com.nizzle94.data.main.movie.genre.GenreRepository
import com.nizzle94.data.main.movie.movie_detail.MovieDetailDataRepository
import com.nizzle94.data.main.movie.movie_detail.MovieDetailRepository
import com.nizzle94.data.main.movie.movies.MoviesDataRepository
import com.nizzle94.data.main.movie.movies.MoviesRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@Module(includes = [NetModule::class, DatabaseModule::class])
class RepoModule {


    @Provides
    @AppScope
    fun providesLoginRepository(endpoint: Endpoint): LoginRepository {
        return LoginRepository(endpoint)
    }

    @Provides
    @AppScope
    fun providesMoviesRepository(moviesDataRepository: MoviesDataRepository): MoviesRepository {
        return moviesDataRepository
    }

    @Provides
    @AppScope
    fun providesMovieDetailRepository(movieDetailDataRepository: MovieDetailDataRepository): MovieDetailRepository {
        return movieDetailDataRepository
    }

    @Provides
    @AppScope
    fun provideGenreRepository(gennreDataRepository: GenreDataRepository): GenreRepository {
        return gennreDataRepository
    }

}