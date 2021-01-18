package com.base.roomlist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.base.roomlist.model.Listfake

@Database(entities = [Listfake::class], version = 2, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao


}