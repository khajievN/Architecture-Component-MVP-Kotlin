package com.nizzle94.data.main.movie.genre

import com.google.gson.annotations.SerializedName

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
data class GenreResponse(@SerializedName("genres") val genreList: List<Genre>)