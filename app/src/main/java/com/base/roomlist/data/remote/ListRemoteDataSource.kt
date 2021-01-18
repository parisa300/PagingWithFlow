package com.base.roomlist.data.remote

import javax.inject.Inject

class ListRemoteDataSource @Inject constructor(
    private val listService: ListService
): BaseDataSource() {


}