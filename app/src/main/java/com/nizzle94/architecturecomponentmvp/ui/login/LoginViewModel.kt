package com.nizzle94.architecturecomponentmvp.ui.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nizzle94.data.login.LoginBody
import com.nizzle94.data.login.UserResponse
import com.nizzle94.data.reponse.BaseResponse
import com.nizzle94.domain.login.LoginUseCase
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 04/06/2018.
 */
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    var errorMessage: MutableLiveData<String> = MutableLiveData()
    var responseResult: MutableLiveData<Result> = MutableLiveData()
    var progressBarStatus: MutableLiveData<Boolean> = MutableLiveData()


    fun login(email: String, password: String) {
        progressBarStatus.postValue(true)
        val loginBody = LoginBody(email, password)
        loginUseCase.execute(loginBody, object : SingleObserver<BaseResponse<UserResponse>> {
            override fun onSuccess(t: BaseResponse<UserResponse>) {
                if (t.isSuccess()) {
                    responseResult.postValue(Result.SUCCESS)
                    errorMessage.postValue("")
                } else {
                    responseResult.postValue(Result.FAILURE)
                    errorMessage.postValue(t.message)
                }
                progressBarStatus.postValue(false)
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
                progressBarStatus.postValue(false)
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        loginUseCase.dispose()
    }

    fun clear() {
        onCleared()
    }

}

enum class Result {
    SUCCESS,
    FAILURE
}