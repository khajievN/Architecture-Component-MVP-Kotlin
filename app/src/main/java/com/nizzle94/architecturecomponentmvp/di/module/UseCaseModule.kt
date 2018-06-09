package com.nizzle94.architecturecomponentmvp.di.module

import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.data.login.LoginRepository
import com.nizzle94.data.main.movie.genre.GenreRepository
import com.nizzle94.data.main.movie.movie_detail.MovieDetailRepository
import com.nizzle94.data.main.movie.movies.MoviesRepository
import com.nizzle94.domain.login.LoginUseCase
import com.nizzle94.domain.main.movie.genre.GenreUseCase
import com.nizzle94.domain.main.movie.movie_detail.MovieDetailUseCase
import com.nizzle94.domain.main.movie.movies.MoviesUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@Module(includes = [RepoModule::class])
class UseCaseModule {

    @AppScope
    @Provides
    @Named("ioScheduler")
    fun providesIoScheduler(): Scheduler = Schedulers.io()


    @AppScope
    @Provides
    @Named("mainThreadScheduler")
    fun providesMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()


    @AppScope
    @Provides
    fun providesLoginUseCase(
            @Named("ioScheduler") ioScheduler: Scheduler,
            @Named("mainThreadScheduler") mainThreadScheduler: Scheduler,
            loginRepository: LoginRepository
    ): LoginUseCase {
        return LoginUseCase(loginRepository, ioScheduler, mainThreadScheduler)

    }

    @AppScope
    @Provides
    fun providesGenreUseCase(
            @Named("ioScheduler") ioScheduler: Scheduler,
            @Named("mainThreadScheduler") mainThreadScheduler: Scheduler,
            genreRepository: GenreRepository
    ): GenreUseCase {
        return GenreUseCase(genreRepository, ioScheduler, mainThreadScheduler)

    }

    @AppScope
    @Provides
    fun providesMoviesUseCase(
            @Named("ioScheduler") ioScheduler: Scheduler,
            @Named("mainThreadScheduler") mainThreadScheduler: Scheduler,
            moviesRepository: MoviesRepository
    ): MoviesUseCase {
        return MoviesUseCase(moviesRepository, ioScheduler, mainThreadScheduler)

    }

    @AppScope
    @Provides
    fun providesMovieDetailUseCase(
            @Named("ioScheduler") ioScheduler: Scheduler,
            @Named("mainThreadScheduler") mainThreadScheduler: Scheduler,
            movieDetailRepository: MovieDetailRepository
    ): MovieDetailUseCase {
        return MovieDetailUseCase(movieDetailRepository, ioScheduler, mainThreadScheduler)

    }
}