package com.base.roomlist.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.base.roomlist.model.Listfake


@Dao
interface UserDao{

    @Query("SELECT * FROM users LIMIT 4 OFFSET :offset")
    suspend fun getUser(offset: Int): List<Listfake>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: Listfake)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<Listfake>)

}