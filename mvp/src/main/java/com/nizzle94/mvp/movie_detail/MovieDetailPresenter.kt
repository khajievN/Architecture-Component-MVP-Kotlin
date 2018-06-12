package com.nizzle94.mvp.movie_detail

import com.nizzle94.data.main.movie.movie_detail.MovieDetailResponse
import com.nizzle94.data.main.movie.movies.MoviesResponse
import com.nizzle94.domain.base.DefaultSingleObserver
import com.nizzle94.domain.main.movie.movie_detail.MovieDetailUseCase
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
class MovieDetailPresenter @Inject constructor(private val movieDetailUseCase: MovieDetailUseCase) :
    BasePresenter<MovieDetailView>() {
    override fun disposeSubscriptions() {

    }

    fun requestMovieDetail(movieId: Int) {
        movieDetailUseCase.execute(MovieDetailObserver(), movieId)
    }

    override fun attachView(view: Any?) {
        super.attachView(view)
        this.getView()?.loadViewModel()
    }


    override fun detachView() {
        super.detachView()
        movieDetailUseCase.dispose()

    }

    inner class MovieDetailObserver : DefaultSingleObserver<MovieDetailResponse>() {
        override fun onSuccess(model: MovieDetailResponse) {
            getView()?.populateView(model)
            getView()?.hideProgressbar()
        }

        override fun onError(error: Throwable) {
            error.printStackTrace()
            getView()?.showError()
            getView()?.hideProgressbar()
        }
    }
}