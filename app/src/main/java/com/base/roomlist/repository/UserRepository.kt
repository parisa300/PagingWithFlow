package com.base.roomlist.repository

import com.base.roomlist.model.Listfake

interface UserRepository {
    suspend fun fetchUserPage(offset: Int): List<Listfake>

}