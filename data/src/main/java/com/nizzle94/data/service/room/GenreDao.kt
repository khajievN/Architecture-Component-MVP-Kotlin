package com.nizzle94.data.service.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.nizzle94.data.entity.Genre
import io.reactivex.Flowable

/**
 * Created by Khajiev Nizomjon on 10/06/2018.
 */
@Dao
interface GenreDao {

    @Query("SELECT * FROM genre")
    fun getGenreList(): Flowable<List<Genre>>

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    fun saveGenreList(genreList: List<Genre>)
}