package com.nizzle94.architecturecomponentmvp.ui.main.search

import android.arch.lifecycle.ViewModel
import com.nizzle94.data.entity.Movie
import com.nizzle94.data.reponse.MoviesResponse

/**
 * Created by Khajiev Nizomjon on 25/06/2018.
 */
class MovieSearchViewModel : ViewModel() {

    var moviesResponse: MoviesResponse? = null
    var movieList: ArrayList<Movie>? = ArrayList()

    fun retainModel(model: MoviesResponse) {
        moviesResponse = model
        movieList?.addAll(model.movieList)
    }

    fun clearModel() {
        moviesResponse = null
        movieList?.clear()
    }

    fun clearAndRetainModel(model: MoviesResponse) {
        clearModel()
        retainModel(model)
    }


}