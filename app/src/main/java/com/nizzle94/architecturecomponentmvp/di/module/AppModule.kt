package com.nizzle94.architecturecomponentmvp.di.module

import android.content.Context
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.architecturecomponentmvp.ui.main.di.MainComponent
import dagger.Module
import dagger.Provides

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@Module()
class AppModule (private val app: App){

    @Provides
    @AppScope
    fun providesContext() : Context = app


}