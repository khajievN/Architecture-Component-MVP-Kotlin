package com.nizzle94.architecturecomponentmvp.ui.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nizzle94.domain.login.LoginUseCase
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 04/06/2018.
 */
class LoginViewModel @Inject constructor(loginUseCase: LoginUseCase) : ViewModel() {

    var errorMessage: MutableLiveData<String> = MutableLiveData()



}