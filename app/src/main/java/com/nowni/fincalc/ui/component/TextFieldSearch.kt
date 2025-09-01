package com.nowni.fincalc.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextFieldSearch(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
) {

    var isSearchActive by remember { mutableStateOf(false) }
    TextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = { Text("Search Calculator") },
        leadingIcon = {

            IconButton(onClick = {
                isSearchActive = false
                onQueryChange("")
            }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Close Search")
            }

        },
        trailingIcon = {
            IconButton(onClick = {
                onQueryChange("")
            }) {
                Icon(Icons.Filled.Close,
                    contentDescription = "Close Search")
            }

        }
    )


}

@Preview
@Composable
private fun TextFieldSearchPreview() {

    MaterialTheme {
        TextFieldSearch(
            query = "",
            onQueryChange = {}

        )

    }

}