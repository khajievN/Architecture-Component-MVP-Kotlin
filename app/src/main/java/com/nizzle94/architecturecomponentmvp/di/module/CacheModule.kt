package com.nizzle94.architecturecomponentmvp.di.module

import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.data.cache.CacheProvider
import dagger.Module
import dagger.Provides
import io.rx_cache2.internal.Disk
import io.rx_cache2.internal.RxCache
import io.rx_cache2.internal.encrypt.BuiltInEncryptor
import io.rx_cache2.internal.encrypt.FileEncryptor
import io.victoralbertos.jolyglot.GsonSpeaker
import javax.inject.Singleton

@Module(includes = [AppModule::class])
class CacheModule(private val app: App) {

    @Provides
    @AppScope
    fun provideGsonSpeaker(): GsonSpeaker {
        return GsonSpeaker()
    }

    @Provides
    @AppScope
    fun provideMoviesCacheProviders(gsonSpeaker: GsonSpeaker): CacheProvider {
        return RxCache.Builder()
            .persistence(app.filesDir, gsonSpeaker)
            .using(CacheProvider::class.java)
    }

    @Provides
    @AppScope
    fun provideDiskCache(gsonSpeaker: GsonSpeaker): Disk {
        return Disk(app.filesDir, FileEncryptor(BuiltInEncryptor()), gsonSpeaker)
    }

}
