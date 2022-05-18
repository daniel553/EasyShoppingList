package com.tripletres.easyshoppinglist.item.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String,
    val qt: Int = 1,
    val store: String = "none"
)