package com.tripletres.easyshoppinglist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tripletres.easyshoppinglist.item.repo.ItemDao

@Database(
    version = 1,
    entities = [ItemDao::class]
)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao
}