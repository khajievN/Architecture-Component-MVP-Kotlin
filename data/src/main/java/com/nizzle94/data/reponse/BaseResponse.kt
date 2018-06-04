package com.nizzle94.data.reponse

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
data class BaseResponse<T>(val code: Int, val data: T, val message: String) {

    fun isSuccess(): Boolean {
        return 200 == code
    }

}