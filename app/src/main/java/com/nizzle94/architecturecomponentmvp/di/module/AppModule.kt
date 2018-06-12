package com.nizzle94.architecturecomponentmvp.di.module

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.MovieDatabase
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.architecturecomponentmvp.ui.main.di.MainComponent
import dagger.Module
import dagger.Provides

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@Module()
class AppModule(private val app: App) {

    @Provides
    @AppScope
    fun providesContext(): Context = app


    @Provides
    @AppScope
    fun provideMovieDatabase(context: Context): MovieDatabase = Room.databaseBuilder(
        context,
        MovieDatabase::class.java, "movie_db"
    ).build()


}