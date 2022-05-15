package com.tripletres.easyshoppinglist.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tripletres.easyshoppinglist.item.model.Item
import com.tripletres.easyshoppinglist.item.repo.ItemDao
import com.tripletres.easyshoppinglist.item.repo.ItemLocalRepo
import com.tripletres.easyshoppinglist.item.vm.ItemViewModel
import com.tripletres.easyshoppinglist.shared.TopAppBar
import com.tripletres.easyshoppinglist.ui.theme.EasyShoppingListTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    EasyShoppingListTheme {
        ItemListPage(navController, null)
    }
}

@Composable
fun ItemListPage(navController: NavHostController, itemViewModel: ItemViewModel?) {
    //val itemViewModel by remember { mutableStateOf(ItemViewModel()) }

    Scaffold(
        topBar = {
            TopAppBar(navController, "Shopping list", false)
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp)
                ,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ItemListMainView(itemViewModel?.items ?: emptyList())
                ItemAddView(itemViewModel)
            }

        }
    )
}

@Composable
fun ItemListMainView(items: List<Item>) {
    ItemListView(items)
}