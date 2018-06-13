package com.nizzle94.architecturecomponentmvp.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nizzle94.data.entity.Genre
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
class MainViewModel @Inject constructor() : ViewModel() {

    val genreList: MutableLiveData<List<Genre>> = MutableLiveData()
//
//    init {
//        genreUseCase.execute(null, object : SingleObserver<GenreResponse> {
//            override fun onSuccess(t: GenreResponse) {
//                movieList.value = t.movieList
//            }
//
//            override fun onSubscribe(d: Disposable) {
//            }
//
//            override fun onError(e: Throwable) {
//                e.printStackTrace()
//            }
//
//        })
//    }

    override fun onCleared() {
        super.onCleared()
//        genreUseCase.dispose()
    }
}