package com.base.roomlist.domain.usecase

import com.base.roomlist.data.local.UserDao
import com.base.roomlist.domain.repository.UserRepository
import com.base.roomlist.model.FakeData
import com.base.roomlist.model.Listfake
import javax.inject.Inject

class GetListUseCase  @Inject constructor(private val userRepository: UserRepository

){

  suspend fun fetchPage(offset: Int): List<Listfake> {
        val usersList: List<Listfake>

      return  userRepository.fetchUserPage(offset)
        }



    }
