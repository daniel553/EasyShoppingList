package com.tripletres.easyshoppinglist.item

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.tripletres.easyshoppinglist.item.model.Item
import com.tripletres.easyshoppinglist.item.vm.ItemViewModel
import com.tripletres.easyshoppinglist.ui.custom.SwipeDeleteItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemListView(itemList: List<Item> = listOf()) {
    val itemViewModel = hiltViewModel<ItemViewModel>()
    LazyColumn {
        items(itemList) {
            SwipeDeleteItem(
                content = { ItemView(it) },
                onItemDismissed = { itemViewModel.remove(it, 100) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemListViewPreview() {
    val items = mutableListOf<Item>()
    (1..4).forEach {
        items.add(Item(it.toLong(), "Nombre $it", "description $it", it))
    }
    ItemListView(items)
}