package com.nizzle94.architecturecomponentmvp.di.module

import com.nizzle94.architecturecomponentmvp.di.scope.AppScope
import com.nizzle94.data.login.LoginRepository
import com.nizzle94.domain.login.LoginUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.NewThreadScheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
@Module(includes = [RepoModule::class])
class UseCaseModule {

    @AppScope
    @Provides
    @Named("ioScheduler")
    fun providesIoScheduler(): Scheduler = Schedulers.io()


    @AppScope
    @Provides
    @Named("mainThreadScheduler")
    fun providesMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()


    @AppScope
    @Provides
    fun providesLoginUseCase(
        @Named("ioScheduler") ioScheduler: Scheduler,
        @Named("mainThreadScheduler") mainThreadScheduler: Scheduler,
        loginRepository: LoginRepository
    ): LoginUseCase {
        return LoginUseCase(loginRepository, ioScheduler, mainThreadScheduler)

    }

}