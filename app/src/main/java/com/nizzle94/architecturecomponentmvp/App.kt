package com.nizzle94.architecturecomponentmvp

import android.app.Application
import com.nizzle94.architecturecomponentmvp.di.component.AppComponent
import com.nizzle94.architecturecomponentmvp.di.component.DaggerAppComponent
import com.nizzle94.architecturecomponentmvp.di.module.AppModule

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
class App : Application() {

    val applicationComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        inject()

    }


    fun inject() {
        applicationComponent.inject(this)
    }


}