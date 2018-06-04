package com.nizzle94.architecturecomponentmvp.ui.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.databinding.ActivityLoginBinding
import com.nizzle94.mvp.BaseActivity
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 04/06/2018.
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginController {


    override fun getLayout(): Int = R.layout.activity_login
    override fun initInjector() {
        (application as App).applicationComponent
            .loginBuilder()
            .build()
            .inject(this)
    }

    lateinit var activityLoginBinding: ActivityLoginBinding

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityLoginBinding.setLifecycleOwner(this)
        activityLoginBinding.vm = presenter.getViewModel()
        loginPresenter.changeErrorMessage()



    }
}