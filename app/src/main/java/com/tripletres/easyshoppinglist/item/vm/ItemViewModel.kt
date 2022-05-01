package com.tripletres.easyshoppinglist.item.vm

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.tripletres.easyshoppinglist.item.model.Item

class ItemViewModel: ViewModel() {
    private val _items = mutableStateListOf<Item>()

    val items: List<Item> get() = _items

    fun addItem(item:Item) {
        _items.add(item)
    }
}