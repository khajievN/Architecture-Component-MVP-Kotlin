package com.nizzle94.data.datasource

import com.nhaarman.mockito_kotlin.mock
import com.nizzle94.data.datasource.DataFactory
import com.nizzle94.data.datasource.MoviesDataSource
import com.nizzle94.data.datasource.MoviesDataStore
import com.nizzle94.data.service.api.MoviesApiService
import com.nizzle94.data.service.room.RoomService
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */
class DataFactoryTest {

    private lateinit var dataFactory: DataFactory

    private val moviesApiService: MoviesApiService = mock()

    private val roomService: RoomService = mock()

    @Before
    fun setUp() {
        dataFactory = DataFactory(moviesApiService, roomService)
    }

    @Test
    fun createDataFactory() {
        val moviesDataStore = dataFactory.createMoviesDataSource()
        assertNotNull(moviesDataStore)
//        assertEquals(MoviesDataSource::class, moviesDataStore);
    }

}