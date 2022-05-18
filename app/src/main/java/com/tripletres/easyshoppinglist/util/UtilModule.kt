package com.tripletres.easyshoppinglist.util

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UtilModule {
    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context): MessageUtil {
        return MessageUtil(context)
    }
}