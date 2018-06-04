package com.nizzle94.architecturecomponentmvp.ui.main

import android.arch.lifecycle.LifecycleOwner

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
interface MainView : LifecycleOwner {
    fun showLoading()
}