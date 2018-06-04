package com.nizzle94.data.reponse

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
data class BaseListResponse<T>(val code: Int, val data: List<T>, val message: String) {

    fun isSuccess(): Boolean {
        return code == 200
    }
}