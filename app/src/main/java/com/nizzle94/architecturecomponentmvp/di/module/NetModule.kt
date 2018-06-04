package com.nizzle94.architecturecomponentmvp.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nizzle94.architecturecomponentmvp.BuildConfig
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.data.Endpoint
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

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
    fun providesRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://everything4droid.com/api/v1/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)

        return retrofit.build()

    }

    @AppScope
    @Provides
    fun providesEndpoint(retrofit: Retrofit): Endpoint {
        return retrofit.create(Endpoint::class.java)
    }


}