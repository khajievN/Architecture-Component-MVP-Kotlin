package com.nizzle94.architecturecomponentmvp.ui.main.movie_detail

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.databinding.FragmentMovieDetailBinding
import com.nizzle94.architecturecomponentmvp.ui.main.MainFragmentController
import com.nizzle94.data.main.movie.movie_detail.MovieDetailResponse
import com.nizzle94.mvp.BaseFragment
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
class MovieDetailFragment : BaseFragment<MovieDetailView, MovieDetailPresenter>(), MovieDetailView {

    override fun showMovieDetail(movieDetailResponse: MovieDetailResponse) {
        binding.vm = movieDetailResponse
    }

    companion object {
        const val MOVIE_ID = "movieId"
    }


    override fun getLayout(): Int = 0

    override fun initInjector() {
        (activity?.application as App).applicationComponent
                .mainBuilder().build().inject(this)
    }

    override fun getMvpView(): MovieDetailView = this

    override fun showLoading() {

    }

    @Inject
    lateinit var movieDetailPresenter: MovieDetailPresenter
    lateinit var binding: FragmentMovieDetailBinding
    private var movieId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieId = arguments?.getInt(MOVIE_ID)!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetailPresenter.init(this, movieId)
    }


}