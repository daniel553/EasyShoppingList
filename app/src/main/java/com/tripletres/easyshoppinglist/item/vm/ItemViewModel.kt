package com.tripletres.easyshoppinglist.item.vm

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tripletres.easyshoppinglist.item.model.Item
import com.tripletres.easyshoppinglist.item.repo.ItemLocalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repo: ItemLocalRepo) : ViewModel() {

    private var _items = mutableStateListOf<Item>()
    val items: List<Item>
        get() = _items

    /**
     * Initializes the items list from local repo
     */
    fun fetchItems() {
        viewModelScope.launch(Dispatchers.Default) {
            _items = repo.getAll().toMutableStateList()
        }
    }

    /**
     * Adds an item to repo then add it to the list of items
     * @param item to be added
     */
    fun addItem(item: Item) {
        viewModelScope.launch(Dispatchers.Default) {
            val id = repo.insert(item)
            val inserted = repo.get(id)
            viewModelScope.launch(Dispatchers.IO) {
                _items.add(inserted)
            }
        }
    }

    /**
     * Update item and list that is content of
     * @param item to be updated
     */
    fun updateItem(index: Int, item: Item) {
        _items[index] = item
        viewModelScope.launch(Dispatchers.Default) {
            repo.update(item)
        }
    }


    /**
     * Adds +1 quantity and updates the list
     */
    fun plus(item: Item) {
        updateItem(_items.indexOf(item), item.copy(qt = item.qt + 1))
    }

    /**
     * Removes -1 quantity or true if need to remove
     * @param item to reduce quantity
     */
    fun minus(item: Item): Boolean {
        if (item.qt > 1) {
            updateItem(_items.indexOf(item), item.copy(qt = item.qt - 1))
            return false
        }
        return true
    }

    /**
     * Removes an item from repo
     * @param item to remove
     */
    fun remove(item: Item) {
        viewModelScope.launch(Dispatchers.Default) {
            repo.delete(item)
            viewModelScope.launch(Dispatchers.IO) {
                _items.remove(item)
            }
        }
    }
}