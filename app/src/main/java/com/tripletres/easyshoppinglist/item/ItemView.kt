package com.tripletres.easyshoppinglist.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tripletres.easyshoppinglist.item.model.Item

@Composable
fun ItemView(item: Item) {
    Card(
        modifier = Modifier
            .padding(8.dp, 6.dp, 8.dp, 6.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(10)
            ),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(8.dp)
        ) {
            Text(
                text = item.name, modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 8.dp)
                    .weight(0.8f)
            )
            Text(text = "x${item.qt}", modifier = Modifier.align(Alignment.CenterVertically))
            Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Clear,
                        "Remove",
                        tint = Color.Gray
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Add,
                        "Add",
                        tint = Color.Gray
                    )
                }
                Checkbox(modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(8.dp),
                    checked = false,
                    onCheckedChange = { /*TODO*/ })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemViewPreview() {
    val item = Item(1, "Nombre", "description", 1)
    ItemView(item)
}