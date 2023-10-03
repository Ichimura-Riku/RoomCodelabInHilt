package com.example.inventory.di

import android.content.Context
import com.example.inventory.data.InventoryDatabase
import com.example.inventory.data.ItemsRepository
import com.example.inventory.data.OfflineItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppDataModules{
    @Provides
    @Singleton
    fun providesItemsRepository(@ApplicationContext context: Context): ItemsRepository {
        return OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }




}


