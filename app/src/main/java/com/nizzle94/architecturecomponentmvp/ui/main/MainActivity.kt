package com.nizzle94.architecturecomponentmvp.ui.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.mvp.BaseActivity
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenreAdapter
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenreFragment
import com.nizzle94.architecturecomponentmvp.util.Const
import com.nizzle94.architecturecomponentmvp.util.replaceFragmentSafely
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.mvp.BaseView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<BaseView, MainPresenter>(), MainView {


    override fun getMvpView(): BaseView = this

    override fun getLayout(): Int = R.layout.activity_main
    override fun initInjector() {
        (application as App).applicationComponent
                .mainBuilder().build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        replaceFragmentSafely(
                fragment = GenreFragment(),
                tag = Const.GENRE_FRAGMENT,
                containerViewId = R.id.container,
                allowStateLoss = true
        )

    }


}
