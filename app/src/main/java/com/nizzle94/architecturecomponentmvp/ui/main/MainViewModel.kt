package com.nizzle94.architecturecomponentmvp.ui.main

import android.arch.lifecycle.ViewModel
import com.nizzle94.domain.login.LoginUseCase
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
class MainViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {






    override fun onCleared() {
        super.onCleared()
        loginUseCase.dispose()
    }
}