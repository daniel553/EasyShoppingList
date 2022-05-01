package com.tripletres.easyshoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tripletres.easyshoppinglist.navigation.MainNavigation
import com.tripletres.easyshoppinglist.ui.theme.EasyShoppingListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyShoppingListTheme {
                MainNavigation()
            }
        }
    }
}
