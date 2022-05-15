package com.tripletres.easyshoppinglist.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tripletres.easyshoppinglist.item.ItemListPage
import com.tripletres.easyshoppinglist.item.vm.ItemViewModel

@Composable
fun MainNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Router.ItemList.route) {

        composable(Router.ItemList.route) {
            val viewModel = hiltViewModel<ItemViewModel>()
            ItemListPage(navController = navController, itemViewModel = viewModel)
        }

    }
}