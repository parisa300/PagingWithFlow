package com.base.roomlist.di

import android.app.Application
import androidx.room.Room
import com.base.roomlist.model.db.AppDatabase
import com.base.roomlist.model.db.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object LocalDatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "users-db")
           .fallbackToDestructiveMigration() // Recreate tables if no migrations were found
            .build()
    }

    @Provides
    fun provideCharacterDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}