package com.nizzle94.architecturecomponentmvp.ui.main.search

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
import com.nizzle94.architecturecomponentmvp.event.SearchEvent
import com.nizzle94.architecturecomponentmvp.ui.base.BaseViewModelFragment
import com.nizzle94.architecturecomponentmvp.ui.main.movies.MoviesAdapter
import com.nizzle94.architecturecomponentmvp.util.RxBus
import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.mvp.search.MovieSearchPresenter
import com.nizzle94.mvp.search.MoviesSearchView
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 25/06/2018.
 */
class MovieSearchFragment : BaseViewModelFragment<MovieSearchViewModel>(), MoviesSearchView, SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {

    }

    override fun initRecyclerView() {
        searchMoviesAdapter = MovieSearchAdapter(context!!, {

        })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = searchMoviesAdapter
        }
        swipeRefreshLayout.setOnRefreshListener(this)
    }

    override val viewModelClass: Class<MovieSearchViewModel>
        get() = MovieSearchViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_search

    override fun loadViewModel() {
    }

    override fun showProgress() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideProgress() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showEmptyView() {
    }

    override fun hideEmptyView() {
    }

    override fun showResult(moviesResponse: MoviesResponse) {
        isSearched = false
        print(moviesResponse.id)
        moviesResponse?.let { viewModel.retainModel(it) }
        searchMoviesAdapter.addItems(viewModel.movieList!!)
    }

    private fun initInjector() {
        (activity?.application as App).applicationComponent
            .mainBuilder().build().inject(this)
    }

    @Inject
    lateinit var movieSearchPresenter: MovieSearchPresenter

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView
    @BindView(R.id.swipeRefreshLayout)
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var searchMoviesAdapter: MovieSearchAdapter

    private var isSearched: Boolean = false

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
        movieSearchPresenter.attachView(this)

        RxBus.listen(SearchEvent::class.java).subscribe {
            if (!isSearched) {
                isSearched = true
                searchMoviesAdapter.clear()
                movieSearchPresenter.searchMovie(it.message)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        movieSearchPresenter.detachView()
        isSearched = false
    }
}