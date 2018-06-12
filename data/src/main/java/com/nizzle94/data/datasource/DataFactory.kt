package com.nizzle94.data.datasource

import com.nizzle94.data.AppScope
import com.nizzle94.data.service.MoviesApiService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Khajiev Nizomjon on 12/06/2018.
 */
class DataFactory @Inject constructor(private val moviesApiService: MoviesApiService) {

    fun createMoviesDataSource(): MoviesDataSource = MoviesDataSource(moviesApiService)
}