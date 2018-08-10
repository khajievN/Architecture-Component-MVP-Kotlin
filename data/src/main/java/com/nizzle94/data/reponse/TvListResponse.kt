package com.nizzle94.data.reponse

import com.google.gson.annotations.SerializedName
import com.nizzle94.data.entity.Genre

/**
 * Created by Khajiev Nizomjon on 09/08/2018.
 */
data class TvListResponse(@SerializedName("genres") val genreList:List<Genre>)