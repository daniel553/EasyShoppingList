package com.tripletres.easyshoppinglist.item

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tripletres.easyshoppinglist.item.model.Item
import com.tripletres.easyshoppinglist.item.vm.ItemViewModel
import com.tripletres.easyshoppinglist.ui.custom.CircleCheckbox

@Preview(showBackground = true)
@Composable
fun ItemViewPreview() {
    val item = Item(1, "Nombre", "description", 1)
    ItemView(item)
}

@Composable
fun ItemView(item: Item) {
    val itemViewModel = hiltViewModel<ItemViewModel>()
    val animateBackground = animateColorAsState(
        if (item.checked)
            MaterialTheme.colors.primary
        else MaterialTheme.colors.surface,
        animationSpec = tween(100, 0, FastOutSlowInEasing),
    )
    Card(
        modifier = Modifier
            .padding(8.dp, 6.dp, 8.dp, 6.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(10)
            ),
        backgroundColor = animateBackground.value, //checkedBackgroundColor(item.checked),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(8.dp)
        ) {
            Text(
                text = item.name,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 8.dp)
                    .weight(0.8f),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                style = if (item.checked)
                    TextStyle(textDecoration = TextDecoration.LineThrough)
                else LocalTextStyle.current
            )

            Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                IconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    enabled = !item.checked,
                    onClick = {
                        if (itemViewModel.minus(item)) {
                            //TODO: Add a confirm dialog
                            itemViewModel.remove(item)
                        }
                    }
                ) {
                    Icon(
                        Icons.Filled.Remove,
                        "Remove",
                        tint = Color.Gray
                    )
                }
                Text(
                    text = "x${item.qt}",
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                IconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    enabled = !item.checked,
                    onClick = {
                        itemViewModel.plus(item)
                    }
                ) {
                    Icon(
                        Icons.Filled.Add,
                        "Add",
                        tint = Color.Gray
                    )
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(8.dp),
                ) {
                    CircleCheckbox(
                        selected = item.checked,
                        onChecked = {
                            itemViewModel.check(item)
                        })
                }
            }
        }
    }
}