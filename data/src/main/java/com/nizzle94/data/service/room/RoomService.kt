package com.nizzle94.data.service.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.nizzle94.data.entity.Genre

/**
 * Created by Khajiev Nizomjon on 10/06/2018.
 */
@Database(entities = arrayOf(Genre::class), version = 1)
abstract class RoomService : RoomDatabase() {

    abstract fun getGenreDao(): GenreDao

}