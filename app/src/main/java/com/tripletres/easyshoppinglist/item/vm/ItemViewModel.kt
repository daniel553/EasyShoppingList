package com.tripletres.easyshoppinglist.item.vm

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tripletres.easyshoppinglist.item.model.Item
import com.tripletres.easyshoppinglist.item.repo.ItemLocalRepo
import com.tripletres.easyshoppinglist.util.LogUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repo: ItemLocalRepo) : ViewModel() {

    private var _items = mutableStateListOf<Item>()
    val items: List<Item>
        get() = _items

    fun fetchItems() {
        viewModelScope.launch(Dispatchers.Default) {
            _items = repo.getAll().toMutableStateList()
        }
    }

    fun addItem(item: Item) {
        viewModelScope.launch(Dispatchers.Default) {
            val id = repo.insert(item)
            val inserted = repo.get(id)
            viewModelScope.launch(Dispatchers.IO) {
                _items.add(inserted)
            }
        }
    }
}