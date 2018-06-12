package com.nizzle94.data.service

import com.nizzle94.data.login.LoginBody
import com.nizzle94.data.login.UserResponse
import com.nizzle94.data.reponse.BaseResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */

interface Endpoint {

    @POST("api/v1/auth/")
    fun login(@Body authBody: LoginBody) : Single<BaseResponse<UserResponse>>

}