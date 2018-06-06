package com.nizzle94.architecturecomponentmvp.ui.login

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import com.nizzle94.mvp.BaseView

/**
 * Created by Khajiev Nizomjon on 04/06/2018.
 */
interface LoginController : BaseView, LifecycleOwner {


    fun showLoading()

    fun success()
}