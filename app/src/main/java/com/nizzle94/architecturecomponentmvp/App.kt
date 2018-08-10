package com.nizzle94.architecturecomponentmvp

import android.app.Application
import com.nizzle94.architecturecomponentmvp.di.component.AppComponent
import com.nizzle94.architecturecomponentmvp.di.component.DaggerAppComponent
import com.nizzle94.architecturecomponentmvp.di.module.AppModule
import com.nizzle94.architecturecomponentmvp.di.module.CacheModule
import com.nizzle94.architecturecomponentmvp.util.RxBus

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
class App : Application() {


    lateinit var rxBus: RxBus
    val applicationComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .cacheModule(CacheModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        inject()

    }


    fun inject() {
        applicationComponent.inject(this)
    }

    fun bus(): RxBus = rxBus

}