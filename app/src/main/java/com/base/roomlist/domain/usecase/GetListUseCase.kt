package com.base.roomlist.domain.usecase

import com.base.roomlist.domain.repository.UserRepository
import javax.inject.Inject

class GetListUseCase  @Inject constructor(private val userRepository: UserRepository){
}