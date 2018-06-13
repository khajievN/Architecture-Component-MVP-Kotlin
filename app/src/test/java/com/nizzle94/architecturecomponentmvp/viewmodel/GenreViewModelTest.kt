package com.nizzle94.architecturecomponentmvp.viewmodel

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import com.nizzle94.architecturecomponentmvp.ui.main.genre.GenreViewModel
import com.nizzle94.data.entity.Genre
import com.nizzle94.data.reponse.GenreResponse
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */
class GenreViewModelTest {

    private lateinit var genreViewModel: GenreViewModel

    private var genreResponse: GenreResponse = mock()

    @Before
    fun setUp() {
        genreViewModel = GenreViewModel()
    }

    @Test
    fun shouldClearAndRetainModel() {
        genreViewModel.clearAndRetainModel(genreResponse)
        assertEquals(genreViewModel.genreResponse, genreResponse)
        assertEquals(genreViewModel.genreList, genreResponse.genreList)
    }

    @Test
    fun shouldRetainModel() {
        val model = createFakeModel()
        genreViewModel.retainModel(model)
        assertEquals(genreViewModel.genreResponse, model)

    }

    @Test
    fun `should populate recycler while model is not null`() {
        val model = createFakeModel()
        genreViewModel.genreResponse = model
        val populateRecycler: () -> Unit = mock()
        val requestGenreList: () -> Unit = mock()

        genreViewModel.loadModel(requestGenreList, populateRecycler)
        verify(populateRecycler).invoke()
        verifyZeroInteractions(requestGenreList)

    }

    @Test
    fun `should request most popular while model is null`() {
        genreViewModel.genreResponse = null
        val populateRecycler: () -> Unit = mock()
        val requestGeneralList: () -> Unit = mock()

        genreViewModel.loadModel(requestGeneralList, populateRecycler)
        verify(requestGeneralList).invoke()
        verifyZeroInteractions(populateRecycler)
    }

    private fun createFakeModel(): GenreResponse {
        val genreResponse = GenreResponse(
            arrayListOf(
                Genre(
                    id = 1,
                    name = "Genre"
                )
            )
        )
        return genreResponse
    }
}