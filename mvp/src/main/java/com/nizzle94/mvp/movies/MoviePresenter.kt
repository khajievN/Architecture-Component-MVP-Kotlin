package com.nizzle94.mvp.movies

import com.nizzle94.data.reponse.MoviesResponse
import com.nizzle94.domain.base.DefaultSingleObserver
import com.nizzle94.domain.main.movie.movies.MoviesUseCase
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
class MoviePresenter @Inject constructor(private val moviesUseCase: MoviesUseCase) :
    BasePresenter<MoviesView>() {
    override fun disposeSubscriptions() {

    }

    fun requestMoviesList(genreId: Int) {
        getView()?.showProgressbar()
        moviesUseCase.execute(MoviesObserver(), genreId)
    }

    override fun attachView(view: Any?) {
        super.attachView(view)
        this.getView()?.initRecyclerAdapter()
        this.getView()?.initSwipeRefreshLayout()
        this.getView()?.loadViewModel()
    }


    override fun detachView() {
        super.detachView()
        moviesUseCase.dispose()

    }

    inner class MoviesObserver : DefaultSingleObserver<MoviesResponse>() {
        override fun onSuccess(model: MoviesResponse) {
            getView()?.populateRecyclerList(model)
            getView()?.hideProgressbar()
        }

        override fun onError(error: Throwable) {
            error.printStackTrace()
            getView()?.showError()
            getView()?.hideProgressbar()
        }
    }
}