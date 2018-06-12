package com.nizzle94.architecturecomponentmvp.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
abstract class BaseViewModelActivity<T : ViewModel> : BaseActivity() {

    protected abstract val viewModelClass: Class<T>

    protected lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(viewModelClass)
    }

}