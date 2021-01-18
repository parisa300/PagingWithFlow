package com.base.roomlist.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.base.roomlist.data.local.UserPagingSource
import com.base.roomlist.domain.repository.UserRepository

class FrgmentViewModel @ViewModelInject constructor(
    private val repository: UserRepository
) :ViewModel(){

    val flow = Pager(PagingConfig(pageSize = 4, prefetchDistance = 4)) {
        UserPagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}