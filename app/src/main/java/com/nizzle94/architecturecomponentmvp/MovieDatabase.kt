package com.nizzle94.architecturecomponentmvp

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.nizzle94.data.main.movie.genre.Genre
import com.nizzle94.data.main.movie.genre.GenreDao

/**
 * Created by Khajiev Nizomjon on 10/06/2018.
 */
@Database(entities = arrayOf(Genre::class), version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun getGenreDao(): GenreDao

}