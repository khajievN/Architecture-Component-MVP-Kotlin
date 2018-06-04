package com.nizzle94.architecturecomponentmvp.ui.main

import android.os.Bundle
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.di.component.DaggerAppComponent
import com.nizzle94.mvp.BaseActivity
import javax.inject.Inject
import com.nizzle94.architecturecomponentmvp.ui.main.di.MainModule


class MainActivity : BaseActivity<MainPresenter>() {
    override fun getLayout(): Int = R.layout.activity_main
    override fun initInjector() {
        (application as App).applicationComponent
            .mainBuilder().build().inject(this)
    }


    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
