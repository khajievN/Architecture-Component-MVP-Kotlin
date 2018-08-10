package com.nizzle94.architecturecomponentmvp.ui.main.tv

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.widget.Toast
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.ui.base.BaseActivity
import com.nizzle94.architecturecomponentmvp.ui.main.MainFragmentController
import com.nizzle94.architecturecomponentmvp.ui.main.movies.MoviesFragment

/**
 * Created by Khajiev Nizomjon on 09/08/2018.
 */
class TvListActivity : BaseActivity(), MainFragmentController {
    override fun openMoviesByGenre(genreId: Int) {
        title = "Genres"
        val bundle = Bundle()
        bundle.putInt(MoviesFragment.GENRE_ID, genreId)
        val moviesFragment = MoviesFragment()
        moviesFragment.arguments = bundle
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, moviesFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun openMovieDetail(movieId: Int) {
    }

    override fun openMovieDetailBySearch(movieId: Int) {
    }

    override fun getLayoutRes(): Int = R.layout.activity_tv_list


    lateinit var tvListFragment: TvListFragment

    private val TAG_TV_LIST_FRAGMENT = "tv_list_fragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        title = "TvList"
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, TvListFragment(), TAG_TV_LIST_FRAGMENT)
                .commit()
        }

    }

}