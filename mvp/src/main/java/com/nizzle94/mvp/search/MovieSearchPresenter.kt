package com.nizzle94.mvp.search

import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.domain.base.DefaultSingleObserver
import com.nizzle94.domain.main.movie.search.MovieSearchUseCase
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 25/06/2018.
 */
class MovieSearchPresenter @Inject constructor(
    private val movieSearchUseCase: MovieSearchUseCase
) : BasePresenter<MoviesSearchView>() {
    override fun disposeSubscriptions() {

    }

    override fun attachView(view: Any?) {
        super.attachView(view)
        getView()?.loadViewModel()
        this.getView()?.initRecyclerView()
    }


    fun searchMovie(keyword: String) {
        getView()?.hideProgress()
        getView()?.hideEmptyView()
        getView()?.showProgress()
        movieSearchUseCase.execute(MovieSearchObserver(), keyword)
    }

    override fun detachView() {
        super.detachView()
        movieSearchUseCase.dispose()
    }

    inner class MovieSearchObserver : DefaultSingleObserver<MoviesResponse>() {
        override fun onSuccess(model: MoviesResponse) {
            getView()?.showResult(model)
            getView()?.hideProgress()
            getView()?.hideEmptyView()
        }

        override fun onError(error: Throwable) {
            error.printStackTrace()
            getView()?.hideProgress()
            getView()?.hideEmptyView()
        }
    }

}