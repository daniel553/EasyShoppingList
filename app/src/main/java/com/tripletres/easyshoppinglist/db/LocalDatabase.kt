package com.tripletres.easyshoppinglist.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.tripletres.easyshoppinglist.item.model.Item
import com.tripletres.easyshoppinglist.item.repo.ItemDao

@Database(
    version = 1,
    entities = [Item::class]
)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao
}