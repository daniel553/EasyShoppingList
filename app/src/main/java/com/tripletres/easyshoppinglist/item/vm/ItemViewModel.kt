package com.tripletres.easyshoppinglist.item.vm

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.tripletres.easyshoppinglist.item.model.Item
import com.tripletres.easyshoppinglist.item.repo.ItemLocalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repo: ItemLocalRepo): ViewModel() {
    //@Inject lateinit var  repo: ItemLocalRepo
    private val _items = mutableStateListOf<Item>()

    val items: List<Item> get() = _items

    fun addItem(item:Item) {
        _items.add(item)
        repo.add(item)
    }
}