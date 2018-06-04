package com.nizzle94.architecturecomponentmvp.ui.login.di

import com.nizzle94.architecturecomponentmvp.di.scope.PerActivity
import com.nizzle94.architecturecomponentmvp.ui.login.LoginActivity
import dagger.Subcomponent

/**
 * Created by Khajiev Nizomjon on 04/06/2018.
 */
@PerActivity
@Subcomponent(modules = [LoginModule::class])
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)

    @Subcomponent.Builder
    interface Builder {
        fun loginModule(loginModule: LoginModule): Builder
        fun build(): LoginComponent
    }

}