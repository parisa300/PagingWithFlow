package com.base.roomlist.model.db

import androidx.paging.PagingSource
import com.base.roomlist.model.Listfake
import com.base.roomlist.repository.UserRepository
import java.net.UnknownHostException

class UserPagingSource(
    private val characterRepository: UserRepository
) : PagingSource<Int, Listfake>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Listfake> {
        return try {
            val nextPageNumber  = params.key ?: 0
            val characterPage = characterRepository.fetchUserPage(nextPageNumber)
            LoadResult.Page(
                data = characterPage,
                prevKey = null,
                nextKey = nextPageNumber + 4
            )
        } catch (e: UnknownHostException) {
            // Unable to connect to the network
            LoadResult.Error(e)
        }
    }
}