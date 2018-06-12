package com.nizzle94.data.service

import com.nizzle94.data.login.LoginBody
import com.nizzle94.data.login.UserResponse
import com.nizzle94.data.reponse.BaseResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
@Singleton
class ApiService @Inject constructor(private val endpoint: Endpoint) : Endpoint {
    override fun login(authBody: LoginBody): Single<BaseResponse<UserResponse>> {
        return endpoint.login(authBody)
    }

}