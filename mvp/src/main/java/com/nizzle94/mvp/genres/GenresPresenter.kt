package com.nizzle94.mvp.genres

import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.domain.base.DefaultSingleObserver
import com.nizzle94.domain.main.movie.genre.GenreUseCase
import com.nizzle94.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
class GenresPresenter @Inject constructor(private val genreUseCase: GenreUseCase) :
    BasePresenter<GenresView>() {
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

    override fun detachView() {
        super.detachView()
        genreUseCase.dispose()

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

}