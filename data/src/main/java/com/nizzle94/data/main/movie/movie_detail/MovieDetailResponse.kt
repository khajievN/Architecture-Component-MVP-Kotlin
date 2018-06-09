package com.nizzle94.data.main.movie.movie_detail

import com.google.gson.annotations.SerializedName

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
data class MovieDetailResponse(
    @SerializedName("homepage") val homepage: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("budget") val budget: Int,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val release_date: String
)