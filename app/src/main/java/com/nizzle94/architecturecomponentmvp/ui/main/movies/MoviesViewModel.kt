package com.nizzle94.architecturecomponentmvp.ui.main.movies

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nizzle94.data.main.movie.movies.MoviesResponse
import com.nizzle94.domain.main.movie.movies.MoviesUseCase
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
class MoviesViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase) : ViewModel() {

    var moviesLiveData: MutableLiveData<MoviesResponse>? = null

    fun getMoviesByGenre(genreId: Int) {
        moviesUseCase.execute(genreId, object : SingleObserver<MoviesResponse> {
            override fun onSuccess(reponse: MoviesResponse) {
                moviesLiveData?.value = reponse
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
            }

        })
    }

    fun getListMoviesByGenre(genreId: Int): MutableLiveData<MoviesResponse>? {
        if (moviesLiveData == null) {
            moviesLiveData = MutableLiveData()
            getMoviesByGenre(genreId)
        }
        return moviesLiveData
    }

}