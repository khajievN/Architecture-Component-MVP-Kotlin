package com.nizzle94.mvp.genres

import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.data.reponse.TvListResponse
import com.nizzle94.domain.base.DefaultSingleObserver
import com.nizzle94.domain.main.movie.genre.GenreUseCase
import com.nizzle94.domain.main.movie.genre.TvListUseCase
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
class GenresPresenter @Inject constructor(
    private val genreUseCase: GenreUseCase,
    private val tvListUseCase: TvListUseCase
) :
    BasePresenter<GenresView<Any>>() {
    override fun disposeSubscriptions() {

    }

    override fun attachView(view: Any?) {
        super.attachView(view)
        this.getView()?.initRecyclerAdapter()
        this.getView()?.initSwipeRefreshLayout()
        this.getView()?.loadViewModel()
    }


    fun requestGenreList() {
        getView()?.showProgressbar()
        genreUseCase.execute(GenreListObserver(), null)
    }

    fun requestTvList() {
        getView()?.showProgressbar()
        tvListUseCase.execute(TvListObserver(), null)
    }

    override fun detachView() {
        super.detachView()
        genreUseCase.dispose()
        tvListUseCase.dispose()

    }

    fun onRefresh() {
        requestGenreList()
    }

    fun onRefreshTvList() {
        requestTvList()
    }

    inner class GenreListObserver : DefaultSingleObserver<GenreResponse>() {
        override fun onSuccess(model: GenreResponse) {
            getView()?.populateRecyclerList(model)
            getView()?.hideProgressbar()
        }

        override fun onError(error: Throwable) {
            error.printStackTrace()
            getView()?.showError()
            getView()?.hideProgressbar()
        }
    }

    inner class TvListObserver : DefaultSingleObserver<TvListResponse>() {
        override fun onSuccess(model: TvListResponse) {
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