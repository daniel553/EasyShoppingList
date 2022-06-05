package com.tripletres.easyshoppinglist.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Delete item with swipe effect
 * @param content the item Row
 * @param onItemDismissed callback when dismiss value
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeDeleteItem(content: @Composable RowScope.() -> Unit, onItemDismissed: () -> Unit) {

    val state = rememberDismissState(
        confirmStateChange = { dismissValue ->
            if (dismissValue == DismissValue.DismissedToStart) {
                onItemDismissed()
            }
            true
        }
    )

    SwipeToDismiss(
        state = state,
        background = {
            val color = when (state.dismissDirection) {
                DismissDirection.StartToEnd -> Color.Transparent
                DismissDirection.EndToStart -> MaterialTheme.colors.error
                null -> Color.Transparent
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = color)
                    .padding(horizontal = 25.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        },
        dismissContent = content,
        directions = setOf(DismissDirection.EndToStart)
    )

}