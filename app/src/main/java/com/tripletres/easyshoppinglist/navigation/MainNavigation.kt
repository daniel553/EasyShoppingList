package com.tripletres.easyshoppinglist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tripletres.easyshoppinglist.item.ItemListPage

@Composable
fun MainNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Router.ItemList.route) {

        composable(Router.ItemList.route) {
            ItemListPage(navController = navController)
        }

    }
}