package com.tripletres.easyshoppinglist.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
                ItemListMainView()
            }

        }
    )
}

@Composable
fun ItemListMainView() {
    ItemListView()
}