package com.base.roomlist.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.base.roomlist.model.Listfake
import com.base.roomlist.model.db.UserDao

@Database(entities = [Listfake::class], version = 2, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao


}