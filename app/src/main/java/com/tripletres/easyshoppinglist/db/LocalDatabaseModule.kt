package com.tripletres.easyshoppinglist.db

import android.content.Context
import androidx.room.Room
import com.tripletres.easyshoppinglist.item.repo.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDatabaseModule {
    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext context: Context): LocalDatabase {
        return Room.databaseBuilder(context, LocalDatabase::class.java, "local-db").build()
    }

    @Provides
    fun provideItemDao(localDatabase: LocalDatabase): ItemDao {
        return localDatabase.itemDao()
    }
}