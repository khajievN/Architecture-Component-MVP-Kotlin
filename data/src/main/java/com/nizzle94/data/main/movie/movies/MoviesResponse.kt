package com.nizzle94.data.main.movie.movies

import com.google.gson.annotations.SerializedName

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
data class MoviesResponse(@SerializedName("id") val id: Int,
                          @SerializedName("results") val movieList: List<Movie>)