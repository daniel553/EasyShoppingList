package com.tripletres.easyshoppinglist.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.tripletres.easyshoppinglist.item.model.Item
import com.tripletres.easyshoppinglist.item.vm.ItemViewModel

@Preview(showBackground = true)
@Composable
fun ItemAddViewPreview() {
    ItemAddView(null)
}

@Composable
fun ItemAddView(itemViewModel: ItemViewModel?) {
    //val itemViewModel by remember { mutableStateOf(ItemViewModel()) }
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth(1f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier.weight(0.85f),
            value = inputvalue.value,
            textStyle = TextStyle(color = Color.White),
            label = { Text(text = "Huevos...", color = Color.White) },
            onValueChange = {
                inputvalue.value = it
            })
        IconButton(
            modifier = Modifier.weight(0.15f),
            onClick = {
                itemViewModel?.addItem(Item(1, inputvalue.value.text, "", 1))
                inputvalue.value = TextFieldValue();
            }) {
            Icon(
                imageVector = Icons.Filled.AddCircle,
                contentDescription = "Add",
                tint = Color.White
            )
        }
    }

}