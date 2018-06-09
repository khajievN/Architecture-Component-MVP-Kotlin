package com.nizzle94.architecturecomponentmvp.ui.main.movies

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.ui.main.MainFragmentController
import com.nizzle94.data.main.movie.movies.Movie
import com.nizzle94.mvp.BaseFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import java.io.Serializable
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
class MoviesFragment : BaseFragment<MoviesView, MoviesPresenter>(), MoviesView {

    companion object {

        const val GENRE_ID = "genreId"


    }


    override fun getLayout(): Int = R.layout.fragment_movies

    override fun initInjector() {
        (activity?.application as App).applicationComponent
            .mainBuilder().build().inject(this)
    }

    override fun getMvpView(): MoviesView = this

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showMoviesList(moviesList: List<Movie>) {
        val adapter = MoviesAdapter(context!!, moviesList, {
            mainFragmentController.openMovieDetail(it.id)
        })
        recyclerView.adapter = adapter

    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }


    @Inject
    lateinit var moviesPresenter: MoviesPresenter
    lateinit var mainFragmentController: MainFragmentController
    private var genreId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        genreId = arguments?.getInt(GENRE_ID)!!
    }

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
        recyclerView.layoutManager = LinearLayoutManager(context!!) as RecyclerView.LayoutManager?
        moviesPresenter.init(this, genreId)
    }


}