package com.nizzle94.architecturecomponentmvp.ui.main.movie_detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.databinding.FragmentMovieDetailBinding
import com.nizzle94.architecturecomponentmvp.ui.base.BaseViewModelFragment
import com.nizzle94.data.reponse.MovieDetailResponse
import com.nizzle94.mvp.movie_detail.MovieDetailPresenter
import com.nizzle94.mvp.movie_detail.MovieDetailView
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
class MovieDetailFragment : BaseViewModelFragment<MovieDetailViewModel>(), MovieDetailView {

    override val viewModelClass: Class<MovieDetailViewModel>
        get() = MovieDetailViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_movie_detail

    override fun loadViewModel() {
        viewModel.loadModel({ movieDetailPresenter.requestMovieDetail(movieId) },
            {
                binding.vm = viewModel.movieDetailResponse
            })
    }

    override fun populateView(moviesResponse: MovieDetailResponse?) {
        moviesResponse?.let { viewModel.retainModel(it) }
        binding.vm = viewModel.movieDetailResponse
    }

    override fun showError() {
    }

    override fun showProgressbar() {
    }

    override fun hideProgressbar() {
    }

    companion object {
        const val MOVIE_ID = "movieId"
    }

    private fun initInjector() {
        (activity?.application as App).applicationComponent
            .mainBuilder().build().inject(this)
    }

    @Inject
    lateinit var movieDetailPresenter: MovieDetailPresenter
    lateinit var binding: FragmentMovieDetailBinding
    private var movieId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieId = arguments?.getInt(MOVIE_ID)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false)
        binding.setLifecycleOwner(this)
        initInjector()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetailPresenter.attachView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        movieDetailPresenter.detachView()
    }

}