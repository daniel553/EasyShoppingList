package com.tripletres.easyshoppinglist.item.repo

import androidx.room.*
import com.tripletres.easyshoppinglist.item.model.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun getAll(): List<Item>
    @Query("SELECT * FROM item WHERE id = :id")
    fun getById(id: Long): Item
    @Query("SELECT * FROM item WHERE store = :storeName")
    fun getByStoreName(storeName: String): Item
    @Insert
    fun insert(item: Item): Long
    @Insert
    fun insert(vararg items: Item)
    @Update
    fun update(item: Item)
    @Delete
    fun delete(item: Item)
    @Query("DELETE FROM item WHERE id = :id")
    fun deleteById(id: Int)
    @Query("DELETE FROM item WHERE store = :storeName")
    fun deleteByStore(storeName: String)
}