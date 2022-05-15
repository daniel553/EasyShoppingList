package com.tripletres.easyshoppinglist.item.vm

import androidx.compose.runtime.mutableStateListOf
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
    var items = mutableStateListOf<Item>()

    fun fetchItems() {
        viewModelScope.launch(Dispatchers.Default) {
            repo.getAll().let { _items ->
                LogUtil.d(_items.toString())
                if(_items.isNotEmpty()) {
                    viewModelScope.launch(Dispatchers.IO) {
                        items.addAll(_items)
                    }
                }
            }
        }
    }

    fun addItem(item: Item) {
        //_items.add(item)
        //repo.add(item)
        viewModelScope.launch(Dispatchers.Default) {
            repo.insert(item)
            viewModelScope.launch(Dispatchers.IO) {
                items.add(item)
            }
        }
    }
}