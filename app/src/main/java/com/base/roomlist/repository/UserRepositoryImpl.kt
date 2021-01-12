package com.base.roomlist.repository

import com.base.roomlist.model.FakeData
import com.base.roomlist.model.Listfake
import com.base.roomlist.model.db.UserDao

import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val fakeData: FakeData

) : UserRepository {


    override suspend fun fetchUserPage(offset: Int): List<Listfake> {
        val usersList: List<Listfake>
        val cachedUser = userDao.getUser(offset)
        if (cachedUser.isEmpty()) {
            usersList = fakeData.Lists
            userDao.insertAll(usersList)


        }
     return  userDao.getUser(offset)

    }



}
