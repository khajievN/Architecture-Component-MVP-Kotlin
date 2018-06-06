package com.nizzle94.architecturecomponentmvp.ui.main.genre

import android.arch.lifecycle.LifecycleOwner
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.mvp.BaseView

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
interface GenreView : LifecycleOwner, BaseView {

    fun showLoading()

    fun showGenreList(genreList: List<Genre>)

    fun hideLoading()
}