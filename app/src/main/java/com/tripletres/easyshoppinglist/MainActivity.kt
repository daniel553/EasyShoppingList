package com.tripletres.easyshoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.room.Room
import com.tripletres.easyshoppinglist.db.LocalDatabase
import com.tripletres.easyshoppinglist.navigation.MainNavigation
import com.tripletres.easyshoppinglist.ui.theme.EasyShoppingListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
