package com.nizzle94.data

import com.nizzle94.data.reponse.BaseResponse
import io.reactivex.Single
import retrofit2.http.POST

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */

interface Endpoint {

    @POST("/")
    fun login(email: String, password: String) : Single<BaseResponse<String>>

}