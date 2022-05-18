package com.tripletres.easyshoppinglist.item

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
    //val itemViewModel by remember { mutableStateOf(ItemViewModel()) }
    val itemViewModel = hiltViewModel<ItemViewModel>()
    itemViewModel.fetchItems()
    Scaffold(
        topBar = {
            TopAppBar(navController, "Shopping list", false)
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ItemListMainView(itemViewModel.items)
            }
        },
        bottomBar = {
            ItemAddView(itemViewModel)
        }
    )
}

@Composable
fun ItemListMainView(items: List<Item>) {
    ItemListView(items)
}