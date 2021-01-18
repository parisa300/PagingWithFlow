package com.base.roomlist.di

import com.base.roomlist.model.FakeData
import com.base.roomlist.data.local.UserDao
import com.base.roomlist.domain.repository.UserRepository
import com.base.roomlist.domain.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped


@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideUserRepository(
        userDao: UserDao,
    fakeData: FakeData

    ): UserRepository {
        return UserRepositoryImpl(userDao,fakeData)
    }
}