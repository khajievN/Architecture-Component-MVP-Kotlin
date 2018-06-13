package com.nizzle94.architecturecomponentmvp.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.data.service.room.RoomService
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.data.cache.CacheProvider
import dagger.Module
import dagger.Provides
import io.rx_cache2.internal.Disk
import io.rx_cache2.internal.RxCache
import io.rx_cache2.internal.encrypt.BuiltInEncryptor
import io.rx_cache2.internal.encrypt.FileEncryptor
import io.victoralbertos.jolyglot.GsonSpeaker

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
    fun provideMovieDatabase(context: Context): RoomService = Room.databaseBuilder(
        context,
        RoomService::class.java, "movie_db"
    ).build()



}