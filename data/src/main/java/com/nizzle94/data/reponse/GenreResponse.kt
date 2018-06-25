package com.nizzle94.data.reponse

import com.google.gson.annotations.SerializedName
import com.nizzle94.data.entity.Genre

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
data class GenreResponse(@SerializedName("genres") val genreList: List<Genre>)