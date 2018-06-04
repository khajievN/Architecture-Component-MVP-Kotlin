package com.nizzle94.architecturecomponentmvp.di.module

import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.data.Endpoint
import com.nizzle94.data.login.LoginRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@Module(includes = [NetModule::class])
class RepoModule {


    @Provides
    @AppScope
    fun providesLoginRepository(endpoint: Endpoint): LoginRepository {
        return LoginRepository(endpoint)
    }

}