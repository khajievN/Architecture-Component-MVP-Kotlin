package com.nizzle94.data.login

import com.nizzle94.data.service.Endpoint
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
class LoginRepository @Inject constructor(private val endpoint: Endpoint) {

    fun login(loginBody: LoginBody?) = endpoint.login(loginBody!!)

}