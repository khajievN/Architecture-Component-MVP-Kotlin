package com.nizzle94.data.main.movie.genre

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */

@Entity(
    tableName = "Genre"
)
data class Genre(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)