package com.nizzle94.architecturecomponentmvp.ui.main.genre

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.mvp.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_genre.*
import javax.inject.Inject
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenreFragment.ViewLifecycleOwner


/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
class GenreFragment : BaseFragment<GenreView, GenrePresenter>(), GenreView {
    override fun getLayout(): Int = R.layout.fragment_genre

    override fun initInjector() {
        (activity?.application as App).applicationComponent
                .mainBuilder().build().inject(this)
    }

    override fun getMvpView(): GenreView = this

    override fun showLoading() {
    }

    override fun showGenreList(genreList: List<Genre>) {
        val adapter = GenreAdapter(context!!, genreList, {
            print("Id : " + it.id)
        })
        recyclerView.adapter = adapter
    }

    override fun hideLoading() {
    }


    @Inject
    lateinit var genrePresenter: GenrePresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = GridLayoutManager(context!!, 2) as RecyclerView.LayoutManager?

    }


    internal class ViewLifecycleOwner : LifecycleOwner {
        override fun getLifecycle(): Lifecycle = lifecycle

        val lifecycle = LifecycleRegistry(this)
    }

}
