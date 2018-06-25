package com.nizzle94.data.reponse

import com.google.gson.annotations.SerializedName
import com.nizzle94.data.entity.Movie

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
data class MoviesResponse(@SerializedName("id") val id: Int,
                          @SerializedName("results") val movieList: List<Movie>)