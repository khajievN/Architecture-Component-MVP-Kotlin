package com.nizzle94.architecturecomponentmvp.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
abstract class BaseViewModelFragment<T : ViewModel> : BaseFragment() {

    protected abstract val viewModelClass: Class<T>

    protected lateinit var viewModel: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(viewModelClass)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}
