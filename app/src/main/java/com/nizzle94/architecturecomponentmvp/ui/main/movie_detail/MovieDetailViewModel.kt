package com.nizzle94.architecturecomponentmvp.ui.main.movie_detail

import android.arch.lifecycle.ViewModel
import com.nizzle94.data.reponse.MovieDetailResponse

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
class MovieDetailViewModel : ViewModel() {

    var movieDetailResponse: MovieDetailResponse? = null


    fun retainModel(model: MovieDetailResponse) {
        movieDetailResponse = model
    }

    fun clearModel() {
        movieDetailResponse = null
    }

    fun clearAndRetainModel(model: MovieDetailResponse) {
        clearModel()
        retainModel(model)
    }

    inline fun loadModel(requestMovieDetail: () -> Unit, populateView: () -> Unit) {
        if (movieDetailResponse == null)
            requestMovieDetail()
        else
            populateView()
    }


}