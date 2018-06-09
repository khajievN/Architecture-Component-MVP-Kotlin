package com.nizzle94.architecturecomponentmvp.ui.main.movie_detail

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nizzle94.data.main.movie.movie_detail.MovieDetailResponse
import com.nizzle94.domain.main.movie.movie_detail.MovieDetailUseCase
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
class MovieDetailViewModel @Inject constructor(private val movieDetailUseCase: MovieDetailUseCase) : ViewModel() {

    var movieDetail: MutableLiveData<MovieDetailResponse>? = null


    private fun getMovieDetail(movieId: Int) {
        movieDetailUseCase.execute(movieId, object : SingleObserver<MovieDetailResponse> {
            override fun onSuccess(t: MovieDetailResponse) {
                movieDetail?.postValue(t)
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

        })
    }



    fun getMovieDetailLive(movieId: Int): MutableLiveData<MovieDetailResponse>? {
        if (movieDetail == null) {
            movieDetail = MutableLiveData()
            getMovieDetail(movieId)
        }
        return movieDetail
    }

}