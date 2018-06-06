package com.nizzle94.architecturecomponentmvp.ui.main.genre

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.data.main.movie.genre.GenreResponse
import com.nizzle94.domain.main.movie.genre.GenreUseCase
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
class GenreViewModel @Inject constructor(private val genreUseCase: GenreUseCase) : ViewModel() {

    val genreList: MutableLiveData<List<Genre>> = MutableLiveData()

    init {
        genreUseCase.execute(null, object : SingleObserver<GenreResponse> {
            override fun onSuccess(t: GenreResponse) {
                genreList.value = t.genreList
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        genreUseCase.dispose()
    }
}