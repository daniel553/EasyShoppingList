package com.tripletres.easyshoppinglist.navigation

sealed class Router(val route: String) {
    object ItemList: Router("ItemList")
}