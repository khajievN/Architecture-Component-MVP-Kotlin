package com.nizzle94.mvp.genres

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nizzle94.data.reponse.GenreResponse
import com.nizzle94.domain.base.DefaultSingleObserver
import com.nizzle94.domain.main.movie.genre.GenreUseCase
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */
class GenresPresenterTest {

    private lateinit var genresPresenter: GenresPresenter

    private var genresView: GenresView = mock()

    private val genreUseCase: GenreUseCase = mock()


    @Before
    fun setUp() {
        genresPresenter = GenresPresenter(genreUseCase)
    }

    @Test
    fun shouldLoadViewModel() {
        genresPresenter.attachView(genresView)
        verify(genresView).loadViewModel()
    }

    @Test
    fun shouldDisposeObserver() {
        genresPresenter.detachView()
        verify(genreUseCase).dispose()
    }

//    @Test
//    fun shouldExecuteUseCase() {
//        genresPresenter.requestGenreList()
//        verify(genreUseCase).execute(any(), null)
//    }


//    @Test
//    fun shouldPassModelPopulateRcycler() {
//        genresPresenter.getView() = genresView
//        val genreResponse: GenreResponse = mock()
//        Mockito.`when`(genreUseCase.execute(any(), any())).thenAnswer {
//            (it.arguments[0] as GenresPresenter.GenreListObserver).onSuccess(genreResponse)
//        }
//        genresPresenter.requestGenreList()
//
//        verify(genresView).populateRecyclerList(genreResponse)
//    }
//
}