package com.nizzle94.architecturecomponentmvp.di.component

import android.content.Context
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.di.module.AppModule
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelFactory
import com.nizzle94.architecturecomponentmvp.ui.login.di.LoginComponent
import com.nizzle94.architecturecomponentmvp.ui.main.di.MainComponent
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelModule
import com.nizzle94.data.Endpoint
import dagger.Component

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@Component(modules = [AppModule::class, ViewModelModule::class])
@AppScope
interface AppComponent {

    fun inject(app: App)

    fun getApplicationContext(): Context

    fun getEndpoint(): Endpoint

    fun getViewModel(): ViewModelFactory

    fun mainBuilder(): MainComponent.Builder

    fun loginBuilder(): LoginComponent.Builder
}