package com.nizzle94.architecturecomponentmvp.ui.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import io.reactivex.disposables.Disposable

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
abstract class BaseActivity :AppCompatActivity() {

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        ButterKnife.bind(this)
    }

    protected fun disposeSubscription() = disposable?.let { if (!it.isDisposed) it.dispose() }

}