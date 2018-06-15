package com.nizzle94.architecturecomponentmvp.ui.main.genre

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
import com.nizzle94.data.entity.Genre
import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.mvp.genres.GenresPresenter
import com.nizzle94.mvp.genres.GenresView
import kotlinx.android.synthetic.main.fragment_genre.*
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */

class GenreFragment : BaseViewModelFragment<GenreViewModel>(), GenresView, SwipeRefreshLayout.OnRefreshListener {

    override fun onRefresh() {
        viewModel.clearModel()
        genrePresenter.onRefresh()
    }

    override fun showProgressbar() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideProgressbar() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun loadViewModel() {
        viewModel.loadModel({ genrePresenter.requestGenreList() },
                {
                    genreAdapter.addItems(genreList = viewModel.genreList as ArrayList<Genre>)
                })
    }

    override fun populateRecyclerList(genreResponse: GenreResponse?) {
        genreResponse?.let { viewModel.retainModel(it) }
        genreAdapter.addItems(genreList = viewModel.genreList!!)
    }

    override fun initSwipeRefreshLayout() {
    }

    override fun initRecyclerAdapter() {
        genreAdapter = GenreAdapter(context!!, {
            mainFragmentController.openMoviesByGenre(it.id)
        })
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
            adapter = genreAdapter
        }
        swipeRefreshLayout.setOnRefreshListener(this)
    }

    override fun showError() {
    }

    override val viewModelClass: Class<GenreViewModel>
        get() = GenreViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_genre

    private lateinit var genreAdapter: GenreAdapter

    private fun initInjector() {
        (activity?.application as App).applicationComponent
                .mainBuilder().build().inject(this)
    }

    @Inject
    lateinit var genrePresenter: GenresPresenter
    lateinit var mainFragmentController: MainFragmentController

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
        genrePresenter.attachView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        genrePresenter.detachView()
    }


}
