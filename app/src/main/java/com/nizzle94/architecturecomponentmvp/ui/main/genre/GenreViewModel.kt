package com.nizzle94.architecturecomponentmvp.ui.main.genre

import android.arch.lifecycle.ViewModel
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.data.main.movie.genre.GenreResponse

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
class GenreViewModel : ViewModel() {


    var genreResponse: GenreResponse? = null
    var genreList: ArrayList<Genre>? = ArrayList()


    fun retainModel(model: GenreResponse) {
        genreResponse = model
        genreList?.addAll(model.genreList)
    }

    fun clearModel() {
        genreResponse = null
        genreList?.clear()
    }

    fun clearAndRetainModel(model: GenreResponse) {
        clearModel()
        retainModel(model)
    }

    inline fun loadModel(requestMostPopular: () -> Unit, populateRecyclerList: () -> Unit) {
        if (genreResponse == null)
            requestMostPopular()
        else
            populateRecyclerList()
    }

}