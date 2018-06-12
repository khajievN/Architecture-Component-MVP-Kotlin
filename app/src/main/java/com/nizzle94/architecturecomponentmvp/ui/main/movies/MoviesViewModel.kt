package com.nizzle94.architecturecomponentmvp.ui.main.movies

import android.arch.lifecycle.ViewModel
import com.nizzle94.data.main.movie.movies.Movie
import com.nizzle94.data.main.movie.movies.MoviesResponse

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
class MoviesViewModel : ViewModel() {


    var movieResponse: MoviesResponse? = null
    var movieList: ArrayList<Movie>? = ArrayList()


    fun retainModel(model: MoviesResponse) {
        movieResponse = model
        movieList?.addAll(model.movieList)
    }

    fun clearModel() {
        movieResponse = null
        movieList?.clear()
    }

    fun clearAndRetainModel(model: MoviesResponse) {
        clearModel()
        retainModel(model)
    }

    inline fun loadModel(requestMostPopular: () -> Unit, populateRecyclerList: () -> Unit) {
        if (movieResponse == null)
            requestMostPopular()
        else
            populateRecyclerList()
    }


}