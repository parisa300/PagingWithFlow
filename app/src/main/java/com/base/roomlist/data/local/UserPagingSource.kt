package com.base.roomlist.data.local

import androidx.paging.PagingSource
import com.base.roomlist.model.Listfake
import com.base.roomlist.domain.repository.UserRepository
import com.base.roomlist.domain.usecase.GetListUseCase
import java.net.UnknownHostException

class UserPagingSource(
    private val getListUseCase: GetListUseCase
) : PagingSource<Int, Listfake>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Listfake> {
        return try {
            val nextPageNumber  = params.key ?: 0
            val characterPage = getListUseCase.fetchPage(nextPageNumber)
            LoadResult.Page(
                data = characterPage,
                prevKey = null,
                nextKey = nextPageNumber + 4
            )
        } catch (e: UnknownHostException) {

            LoadResult.Error(e)
        }
    }
}