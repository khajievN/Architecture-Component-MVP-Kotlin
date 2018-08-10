package com.nizzle94.mvp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
abstract class BaseActivity<V : BaseView, P : BasePresenter<Any>> : AppCompatActivity() {

    @Inject
    lateinit var presenter: P

    protected abstract fun getLayout(): Int
    protected abstract fun initInjector()
    protected abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)
        setContentView(getLayout())

        initInjector()
        initPresenter()
        init()
    }

    private fun initPresenter() {
        presenter.attachView(getMvpView())
    }

    override fun onDestroy() {
        presenter.disposeSubscriptions()
        presenter.detachView()
        super.onDestroy()
    }

    abstract fun getMvpView(): V

}
