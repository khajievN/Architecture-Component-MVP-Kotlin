package com.nizzle94.architecturecomponentmvp.ui.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.databinding.ActivityLoginBinding
import com.nizzle94.architecturecomponentmvp.ui.main.MainActivity
import com.nizzle94.mvp.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 04/06/2018.
 */
class LoginActivity : BaseActivity<LoginController, LoginPresenter>(), LoginController {
    override fun success() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun getMvpView(): LoginController = this

    override fun showLoading() {
    }


    override fun getLayout(): Int = R.layout.activity_login
    override fun initInjector() {
        (application as App).applicationComponent
                .loginBuilder()
                .build()
                .inject(this)
    }


    private lateinit var activityLoginBinding: ActivityLoginBinding

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityLoginBinding.setLifecycleOwner(this)
        activityLoginBinding.vm = loginPresenter.getViewModel()


        loginBtn.setOnClickListener {
            loginPresenter.login(emailT.text.toString(), passwordT.text.toString())
        }

    }
}