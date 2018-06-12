package com.nizzle94.architecturecomponentmvp.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nizzle94.architecturecomponentmvp.BuildConfig
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.data.service.Endpoint
import com.nizzle94.data.service.MoviesEndpoint
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */

@Module()
class NetModule {


    @AppScope
    @Provides
    fun providesGson(): Gson {
        val gson = GsonBuilder()
                .setLenient()
        return gson.create()
    }


    @AppScope
    @Provides
    @Named("everything4droid.com_client")
    fun providesOkHttpClient(): OkHttpClient {

        val okHttpClient = OkHttpClient.Builder()
        if (BuildConfig.BUILD_TYPE == "debug") {
            okHttpClient.addInterceptor { chain ->
                println(chain.request())
                chain.proceed(chain.request())
            }
        }
        return okHttpClient.build()
    }

    @AppScope
    @Provides
    @Named("themoviedb.com_client")
    fun providesMovieOkHttpClient(): OkHttpClient {

        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.addInterceptor {
            val original: Request = it.request()

            val request = original.newBuilder()
                    .addHeader("api_key", "e1158b8ecd86f1263edb032b433add44")
                    .addHeader("language", "en-US")
                    .method(original.method(), original.body())
                    .build()

            return@addInterceptor it.proceed(request)

        }
        return httpClientBuilder.build()
    }


    @AppScope
    @Provides
    @Named("everything4droid.com")
    fun providesRetrofit(gson: Gson, @Named("everything4droid.com_client") client: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://everything4droid.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)

        return retrofit.build()

    }


    @AppScope
    @Provides
    @Named("themoviedb.com")
    fun providesMoviesRetrofit(gson: Gson, @Named("themoviedb.com_client") client: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)

        return retrofit.build()

    }

    @AppScope
    @Provides
    fun providesEndpoint(@Named("everything4droid.com") retrofit: Retrofit): Endpoint {
        return retrofit.create(Endpoint::class.java)
    }

    @AppScope
    @Provides
    fun providesMoviesEndpoint(@Named("themoviedb.com") retrofit: Retrofit): MoviesEndpoint {
        return retrofit.create(MoviesEndpoint::class.java)
    }

}