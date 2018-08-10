package com.nizzle94.architecturecomponentmvp.ui.main.tv

import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
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
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenreAdapter
import com.nizzle94.architecturecomponentmvp.ui.main.search.MovieSearchAdapter
import com.nizzle94.data.entity.Genre
import com.nizzle94.data.reponse.TvListResponse
import com.nizzle94.mvp.genres.GenresPresenter
import com.nizzle94.mvp.genres.GenresView
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 09/08/2018.
 */
class TvListFragment : BaseViewModelFragment<TvListViewModel>(), GenresView<TvListResponse>,
    SwipeRefreshLayout.OnRefreshListener {
    override fun loadViewModel() {
        viewModel.loadModel({ genrePresenter.requestTvList() },
            {
                genreAdapter.addItems(genreList = viewModel.genreList as ArrayList<Genre>)
            })
    }

    override fun populateRecyclerList(response: TvListResponse?) {
        response?.let { viewModel.retainModel(it) }
        genreAdapter.addItems(genreList = viewModel.genreList!!)
    }

    override fun initSwipeRefreshLayout() {
    }

    override fun initRecyclerAdapter() {
        genreAdapter = GenreAdapter(context!!) {
            mainFragmentController.openMoviesByGenre(it.id)
        }
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
            adapter = genreAdapter
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

    override fun onRefresh() {
        viewModel.clearModel()
        genrePresenter.onRefreshTvList()
    }

    override val viewModelClass: Class<TvListViewModel>
        get() = TvListViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_tv_list

    @Inject
    lateinit var genrePresenter: GenresPresenter
    lateinit var mainFragmentController: MainFragmentController
    private lateinit var genreAdapter: GenreAdapter
    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView
    @BindView(R.id.progressBar)
    lateinit var progressBar: ProgressBar
    @BindView(R.id.swipeRefreshLayout)
    lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            mainFragmentController = activity as MainFragmentController
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true;
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

    private fun initInjector() {
        (activity?.application as App).applicationComponent
            .mainBuilder().build().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        genrePresenter.attachView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        genrePresenter.detachView()
    }


}