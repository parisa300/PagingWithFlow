package com.base.roomlist.domain.repository

import com.base.roomlist.model.Listfake

interface UserRepository : BaseRepository{
    suspend fun fetchUserPage(offset: Int): List<Listfake>

}