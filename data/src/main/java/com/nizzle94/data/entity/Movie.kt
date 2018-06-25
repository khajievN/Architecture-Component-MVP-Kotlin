package com.nizzle94.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Khajiev Nizomjon on 07/06/2018.
 */
data class Movie(@SerializedName("id") val id: Int,
                 @SerializedName("title") val title: String,
                 @SerializedName("overview") val overview: String,
                 @SerializedName("backdrop_path") val backgroundImagePath: String,
                 @SerializedName("poster_path") val posterPath: String,
                 @SerializedName("release_date") val releaseDate: String,
                 @SerializedName("vote_count") val voteCount: Int)