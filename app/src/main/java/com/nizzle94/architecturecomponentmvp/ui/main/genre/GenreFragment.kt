package com.nizzle94.architecturecomponentmvp.ui.main.genre

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.di.viewmodel.ViewModelFactory
import com.nizzle94.architecturecomponentmvp.ui.main.MainFragmentController
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.mvp.BaseFragment
import kotlinx.android.synthetic.main.fragment_genre.*
import javax.inject.Inject

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
        progressBar.visibility = View.VISIBLE
    }

    override fun showGenreList(genreList: List<Genre>) {
        val adapter = GenreAdapter(context!!, genreList, {
            mainFragmentController.openMoviesByGenre(it.id)
        })
        recyclerView.adapter = adapter
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }


    @Inject
    lateinit var genrePresenter: GenrePresenter
    lateinit var mainFragmentController: MainFragmentController


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            mainFragmentController = activity as MainFragmentController
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = GridLayoutManager(context!!, 2)
        genrePresenter.init(this)

    }

}
