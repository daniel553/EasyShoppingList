package com.tripletres.easyshoppinglist.item

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tripletres.easyshoppinglist.item.model.Item

@Composable
fun ItemListView(itemList: List<Item> = listOf()) {
    LazyColumn {
        items(itemList) {
            ItemView(it)
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