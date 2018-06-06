package com.nizzle94.mvp

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistryOwner
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
abstract class BaseFragment<V : BaseView, P : BasePresenter<Any>> : Fragment() {

    @Inject
    lateinit var presenter: P

    protected abstract fun getLayout(): Int
    protected abstract fun initInjector()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(getLayout(), container, false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjector()
        initPresenter()
    }

    private fun initPresenter() {
        presenter.attachView(getMvpView())
        presenter.initialise()
    }

    override fun onDestroy() {
        presenter.disposeSubscriptions()
        presenter.detachView()
        super.onDestroy()
    }

    override fun getLifecycle(): Lifecycle {
        return super.getLifecycle()
    }

    abstract fun getMvpView(): V

}