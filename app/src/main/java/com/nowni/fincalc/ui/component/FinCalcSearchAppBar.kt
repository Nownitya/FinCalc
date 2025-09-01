package com.nowni.fincalc.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FinCalcSearchAppBar(
    modifier: Modifier = Modifier,
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    query: String,
    onQueryChange: (String) -> Unit,
    isSearchActive: Boolean,
    onSearchActiveChange: (Boolean) -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
) {

    val focusRequester = remember { FocusRequester() }
    val keyBoardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(true) {
        if (isSearchActive) {
            focusRequester.requestFocus()
            keyBoardController?.show()
        }
    }
    CenterAlignedTopAppBar(
        title = {
            if (!isSearchActive) {
                Text(text = title, style = MaterialTheme.typography.titleLarge)
            } else {
                TextField(
                    value = query,
                    onValueChange = onQueryChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .then(modifier)
                        .focusRequester(focusRequester),
                    placeholder = {
                        Text(
                            text = "Search Calculator", style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    leadingIcon = {
                        IconButton(onClick = {
                            onQueryChange("")
                            onSearchActiveChange(false)
                            keyBoardController?.hide()
                        }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Close Search"
                            )
                        }
                    },
                    trailingIcon = {
                        if (query.isNotEmpty()) {
                            IconButton(onClick = { onQueryChange("") }) {
                                Icon(Icons.Default.ClearAll, contentDescription = "Clear Search")
                            }
                        }
                    },

                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.onSurface,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent
                    )
                )

            }
        },
        modifier = Modifier.fillMaxWidth(),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Navigate Back"
                    )
                }
            }
        },
        actions = {
            if (!isSearchActive) {
                IconButton(onClick = { onSearchActiveChange(true) }) {
                    Icon(
                        Icons.Default.Search, contentDescription = "Search"
                    )
                }
            }
        },
        expandedHeight = TopAppBarDefaults.TopAppBarExpandedHeight,
        windowInsets = TopAppBarDefaults.windowInsets,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            scrolledContainerColor = MaterialTheme.colorScheme.surface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            actionIconContentColor = MaterialTheme.colorScheme.onSurface,
        ),
        scrollBehavior = scrollBehavior,
        )

}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun FinCalSearchAppBarPreview() {
    var query by remember { mutableStateOf("") }
    MaterialTheme {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        var isSearchActive by remember { mutableStateOf(false) }
        FinCalcSearchAppBar(
            title = "FinCalc",
            canNavigateBack = false,
            query = query,
            onQueryChange = { query = it },
            isSearchActive = isSearchActive,
            onSearchActiveChange = { isSearchActive = it },
            scrollBehavior = scrollBehavior
        )


    }
}