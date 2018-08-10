package com.nizzle94.architecturecomponentmvp.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.nizzle94.architecturecomponentmvp.App
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.event.SearchEvent
import com.nizzle94.architecturecomponentmvp.ui.main.movie_detail.MovieDetailFragment
import com.nizzle94.architecturecomponentmvp.ui.main.movies.MoviesFragment
import com.nizzle94.architecturecomponentmvp.ui.main.tv.TvListActivity
import com.nizzle94.architecturecomponentmvp.util.RxBus
import com.nizzle94.mvp.BaseActivity
import com.nizzle94.mvp.BaseView


class MainActivity : BaseActivity<BaseView, MainPresenter>(), MainView, MainFragmentController {
    override fun openMovieDetailBySearch(movieId: Int) {
        val bundle = Bundle()
        bundle.putInt(MovieDetailFragment.MOVIE_ID, movieId)
        controller.navigate(R.id.action_moviesFragment_to_movieDetailFragment, bundle)
    }

    override fun init() {
        toolbar = findViewById<Toolbar>(R.id.toolbarA) as Toolbar
        searchView = findViewById<MaterialSearchView>(R.id.search_viewA) as MaterialSearchView
        setSupportActionBar(toolbar)

        searchView!!.setOnSearchViewListener(object : MaterialSearchView.SearchViewListener {
            override fun onSearchViewShown() {
                controller.navigate(R.id.action_genreFragment_to_movieSearchFragment)
            }

            override fun onSearchViewClosed() {
                onBackPressed()
            }
        })

        searchView!!.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                RxBus.publish(SearchEvent(query))
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()

                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

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
    private var searchView: MaterialSearchView? = null
    private var toolbar: Toolbar? = null
    private var isMainScreen: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        controller = Navigation.findNavController(this, R.id.nav_host_fragment)

        controller.addOnNavigatedListener { controller, destination ->
            when (destination.label) {
                "GenreFragment" -> {
                    isMainScreen = true
                    invalidateOptionsMenu()
                }
                "MoviesFragment" -> {
                    isMainScreen = false
                    invalidateOptionsMenu()
                }
                "MovieDetailFragment" -> {
                    isMainScreen = false
                    invalidateOptionsMenu()
                }
            }
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val item = menu?.findItem(R.id.search)
        item?.isVisible = isMainScreen
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)
        val item = menu?.findItem(R.id.search)
        searchView!!.setMenuItem(item);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.tvList -> {
                val intent = Intent(this, TvListActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
