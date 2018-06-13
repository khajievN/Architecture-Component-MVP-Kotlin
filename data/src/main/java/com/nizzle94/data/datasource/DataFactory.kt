package com.nizzle94.data.datasource

import com.nizzle94.data.cache.CacheProvider
import com.nizzle94.data.cache.EvictCache
import com.nizzle94.data.service.api.MoviesApiService
import com.nizzle94.data.service.room.RoomService
import javax.inject.Inject

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
class DataFactory @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val roomService: RoomService
) {

    fun createMoviesDataSource(): MoviesDataStore = MoviesDataSource(moviesApiService)

}