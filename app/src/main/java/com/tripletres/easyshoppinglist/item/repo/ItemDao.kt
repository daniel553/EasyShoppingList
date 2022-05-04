package com.tripletres.easyshoppinglist.item.repo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.tripletres.easyshoppinglist.item.model.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun getAll(): List<Item>
    @Query("SELECT * FROM item WHERE id = :id")
    fun getById(id: Int): Item
    @Query("SELECT * FROM item WHERE store = :storeName")
    fun getByStoreName(storeName: String): Item
    @Insert
    fun insert(vararg items: Item)
    @Delete
    fun delete(item: Item)
    @Query("DELETE FROM item WHERE id = :id")
    fun deleteById(id: Int)
    @Query("DELETE FROM item WHERE store = :storeName")
    fun deleteByStore(storeName: String)
}