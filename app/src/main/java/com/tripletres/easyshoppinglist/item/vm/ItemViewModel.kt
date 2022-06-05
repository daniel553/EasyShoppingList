package com.tripletres.easyshoppinglist.item.vm

import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tripletres.easyshoppinglist.R
import com.tripletres.easyshoppinglist.item.model.Item
import com.tripletres.easyshoppinglist.item.repo.ItemLocalRepo
import com.tripletres.easyshoppinglist.util.MessageUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val repo: ItemLocalRepo,
    private val msg: MessageUtil
) : ViewModel() {

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
            if (!verifyItem(item)) {
                viewModelScope.launch(Dispatchers.Main) {
                    msg.toast(R.string.msg_item_not_complete, Toast.LENGTH_SHORT)
                }
            } else {
                val id = repo.insert(item)
                val inserted = repo.get(id)
                viewModelScope.launch(Dispatchers.Main) {
                    _items.add(inserted)
                }
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
     * @param toDelay time milliseconds to delay 0 by default
     */
    fun remove(item: Item, toDelay: Long = 0) {
        viewModelScope.launch(Dispatchers.Default) {
            if(toDelay > 0) delay(toDelay)
            repo.delete(item)
            viewModelScope.launch(Dispatchers.Main) {
                _items.remove(item)
            }
        }
    }

    /**
     * Mark as checked or unchecked
     */
    fun check(item: Item) {
        val index = _items.indexOf(item)
        this.updateItem(index, item.copy(checked = !item.checked))
    }

    //-Private methods ------------------------------------

    private fun verifyItem(item: Item): Boolean {
        if (item.name.isNotEmpty() && item.store.isNotEmpty()) {
            return true
        }
        return false
    }

}