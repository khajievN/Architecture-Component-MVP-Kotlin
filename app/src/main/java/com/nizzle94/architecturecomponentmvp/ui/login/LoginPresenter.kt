package com.nizzle94.architecturecomponentmvp.ui.login

import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 04/06/2018.
 */
class LoginPresenter @Inject constructor(private val loginViewModel: LoginViewModel) :
    BasePresenter<LoginController>() {
    override fun disposeSubscriptions() {

    }

    override fun initialise() {

    }

    fun getViewModel(): LoginViewModel {
        return loginViewModel
    }

    fun changeErrorMessage() {
        loginViewModel.errorMessage.value =  " Asaskldaskdka"
    }

}