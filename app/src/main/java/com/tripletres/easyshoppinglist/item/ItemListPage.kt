package com.tripletres.easyshoppinglist.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tripletres.easyshoppinglist.item.model.Item
import com.tripletres.easyshoppinglist.item.vm.ItemViewModel
import com.tripletres.easyshoppinglist.shared.TopAppBar
import com.tripletres.easyshoppinglist.ui.theme.EasyShoppingListTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    EasyShoppingListTheme {
        ItemListPage(navController)
    }
}

@Composable
fun ItemListPage(navController: NavHostController) {
    val itemViewModel by remember { mutableStateOf(ItemViewModel()) }
    Scaffold(
        topBar = {
            TopAppBar(navController, "Shopping list", false)
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ItemListMainView(itemViewModel.items)
                TextButton(
                    onClick = {
                        itemViewModel.addItem(Item(1, "Name", "", 1))
                    }) {
                    Text(text = "Add")
                }
            }

        }
    )
}

@Composable
fun ItemListMainView(items: List<Item>) {
    ItemListView(items)
}