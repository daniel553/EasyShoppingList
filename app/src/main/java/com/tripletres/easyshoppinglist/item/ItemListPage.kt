package com.tripletres.easyshoppinglist.item

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tripletres.easyshoppinglist.Greeting
import com.tripletres.easyshoppinglist.ui.theme.EasyShoppingListTheme
import com.tripletres.easyshoppinglist.ui.theme.Purple700

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
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = AnnotatedString("Triple3 all rights reserved (c)"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Purple700
            )
        )
    }
}