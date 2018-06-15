package com.nizzle94.architecturecomponentmvp.ui.main.movies

import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import butterknife.BindView
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.ui.base.BaseViewModelFragment
import com.nizzle94.architecturecomponentmvp.ui.main.MainFragmentController
import com.nizzle94.data.entity.Movie
import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.mvp.movies.MoviePresenter
import com.nizzle94.mvp.movies.MoviesView
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
class MoviesFragment : BaseViewModelFragment<MoviesViewModel>(), MoviesView, SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {
        viewModel.clearModel()
        moviesPresenter.requestMoviesList(genreId)
    }

    override val viewModelClass: Class<MoviesViewModel>
        get() = MoviesViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_movies

    override fun loadViewModel() {
        viewModel.loadModel({ moviesPresenter.requestMoviesList(genreId) },
                {
                    moviesAdapter.addItems(viewModel.movieList as ArrayList<Movie>)
                })
    }

    override fun populateRecyclerList(moviesResponse: MoviesResponse?) {
        moviesResponse?.let { viewModel.retainModel(it) }
        moviesAdapter.addItems(viewModel.movieList!!)
    }

    override fun initSwipeRefreshLayout() {
    }

    override fun initRecyclerAdapter() {
        moviesAdapter = MoviesAdapter(context!!, {
            mainFragmentController.openMovieDetail(it.id)
        })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = moviesAdapter
        }
        swipeRefreshLayout.setOnRefreshListener(this)
    }

    override fun showError() {
    }

    override fun showProgressbar() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideProgressbar() {
        swipeRefreshLayout.isRefreshing = false
    }

    companion object {

        const val GENRE_ID = "genreId"


    }


    private fun initInjector() {
        (activity?.application as App).applicationComponent
                .mainBuilder().build().inject(this)
    }


    @Inject
    lateinit var moviesPresenter: MoviePresenter
    private lateinit var moviesAdapter: MoviesAdapter

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView
    @BindView(R.id.progressBar)
    lateinit var progressBar: ProgressBar
    @BindView(R.id.swipeRefreshLayout)
    lateinit var swipeRefreshLayout: SwipeRefreshLayout

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

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View? = super.onCreateView(inflater, container, savedInstanceState)
        initInjector()
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesPresenter.attachView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        moviesPresenter.detachView()
    }

}