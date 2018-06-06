package com.nizzle94.domain.login

import com.nizzle94.data.login.LoginBody
import com.nizzle94.data.login.LoginRepository
import com.nizzle94.data.login.UserResponse
import com.nizzle94.data.reponse.BaseResponse
import com.nizzle94.domain.UseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
class LoginUseCase
@Inject constructor(
    private val loginRepository: LoginRepository,
    private val backgroundThread: Scheduler,
    private val mainThread: Scheduler
) : UseCase<BaseResponse<UserResponse>, LoginBody>(backgroundThread, mainThread) {
    override fun buildUseCaseSingle(params: LoginBody?): Single<BaseResponse<UserResponse>> {
        return loginRepository.login(loginBody = params)
    }

}