package com.nizzle94.architecturecomponentmvp.ui.login

import android.arch.lifecycle.*
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.support.v4.app.Fragment
import com.nizzle94.mvp.BasePresenter
import com.nizzle94.mvp.BaseView
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 04/06/2018.
 */
class LoginPresenter @Inject constructor(private val loginViewModel: LoginViewModel) :
        BasePresenter<LoginController>() {
//    override fun initialise() {
//        loginViewModel.responseResult.observe(getView()!!, Observer<Result> {
//            when (it) {
//                Result.SUCCESS -> {
//                    getView()?.success()
//                }
//
//                Result.FAILURE -> {
//
//                }
//            }
//        })
//    }

    override fun disposeSubscriptions() {
        loginViewModel.clear()
    }


    fun login(email: String, password: String) {
        loginViewModel.login(email, password)
    }


    fun getViewModel(): LoginViewModel {
        return loginViewModel
    }



}


