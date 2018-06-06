package com.nizzle94.architecturecomponentmvp.ui.login.di

import com.nizzle94.architecturecomponentmvp.di.scope.PerActivity
import com.nizzle94.architecturecomponentmvp.ui.login.LoginPresenter
import com.nizzle94.architecturecomponentmvp.ui.login.LoginViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Khajiev Nizomjon on 04/06/2018.
 */
@Module
class LoginModule {




    @PerActivity
    @Provides
    fun providesLoginPresenter(loginViewModel: LoginViewModel): LoginPresenter =
        LoginPresenter(loginViewModel)
}