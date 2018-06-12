package com.nizzle94.architecturecomponentmvp.di.module

import com.nizzle94.architecturecomponentmvp.MovieDatabase
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by Khajiev Nizomjon on 10/06/2018.
 */
@Module(includes = [AppModule::class])
class DatabaseModule {


    @Provides
    @AppScope
    fun providesGenreDao(movieDatabase: MovieDatabase) = movieDatabase.getGenreDao()


}