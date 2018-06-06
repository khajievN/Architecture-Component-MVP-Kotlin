package com.nizzle94.architecturecomponentmvp.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.domain.main.movie.genre.GenreUseCase
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 03/06/2018.
 */
class MainViewModel @Inject constructor(private val genreUseCase: GenreUseCase) : ViewModel() {

    val genreList: MutableLiveData<List<Genre>> = MutableLiveData()
//
//    init {
//        genreUseCase.execute(null, object : SingleObserver<GenreResponse> {
//            override fun onSuccess(t: GenreResponse) {
//                genreList.value = t.genreList
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
        genreUseCase.dispose()
    }
}