package com.nizzle94.architecturecomponentmvp.ui.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.mvp.BaseActivity
import com.nizzle94.architecturecomponentmvp.ui.main.movie_detail.MovieDetailFragment
import com.nizzle94.architecturecomponentmvp.ui.main.movies.MoviesFragment
import com.nizzle94.mvp.BaseView


class MainActivity : BaseActivity<BaseView, MainPresenter>(), MainView, MainFragmentController {
    override fun openMoviesByGenre(genreId: Int) {
        val bundle = Bundle()
        bundle.putInt(MoviesFragment.GENRE_ID, genreId)
        controller.navigate(R.id.action_genreFragment_to_moviesFragment, bundle)

    }

    override fun openMovieDetail(movieId: Int) {
        val bundle = Bundle()
        bundle.putInt(MovieDetailFragment.MOVIE_ID, movieId)
        controller.navigate(R.id.action_moviesFragment_to_movieDetailFragment, bundle)
    }


    override fun getMvpView(): BaseView = this

    override fun getLayout(): Int = R.layout.activity_main
    override fun initInjector() {
        (application as App).applicationComponent
                .mainBuilder().build().inject(this)
    }

    lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        controller = Navigation.findNavController(this, R.id.nav_host_fragment)

    }


}
