package com.nizzle94.architecturecomponentmvp.ui.main.tv

import android.arch.lifecycle.ViewModel
import com.nizzle94.data.entity.Genre
import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.data.reponse.TvListResponse

/**
 * Created by Khajiev Nizomjon on 09/08/2018.
 */
class TvListViewModel: ViewModel(){


    var tvListResponse: TvListResponse? = null
    var genreList: ArrayList<Genre>? = ArrayList()


    fun retainModel(model: TvListResponse) {
        tvListResponse = model
        genreList?.addAll(model.genreList)
    }

    fun clearModel() {
        tvListResponse = null
        genreList?.clear()
    }

    fun clearAndRetainModel(model: TvListResponse) {
        clearModel()
        retainModel(model)
    }

    inline fun loadModel(requestMostPopular: () -> Unit, populateRecyclerList: () -> Unit) {
        if (tvListResponse == null)
            requestMostPopular()
        else
            populateRecyclerList()
    }

}