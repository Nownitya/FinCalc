package com.nowni.fincalc.ui.screens.home_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nowni.fincalc.R
import com.nowni.fincalc.domain.calculator.CalculatorList
import com.nowni.fincalc.ui.component.CalculatorCard
import com.nowni.fincalc.ui.component.FinCalcSearchAppBar
import com.nowni.fincalc.ui.theme.FinCalcTheme
import com.nowni.fincalc.utils.helper.filterCalculators

@SuppressLint("UnusedValue")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    listState: LazyListState,
    onCardClick: (index: Int) -> Unit = {},
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    var searchQuery by remember { mutableStateOf("") }
    var isSearchActive by remember { mutableStateOf(false) }
    val keyBoardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    val filteredItems = remember(searchQuery) {
        filterCalculators(searchQuery, context = context)
    }

    Scaffold(
        modifier = Modifier.nestedScroll(
            scrollBehavior.nestedScrollConnection
        ),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            FinCalcSearchAppBar(
                title = stringResource(id = R.string.app_name),
                canNavigateBack = false,
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                isSearchActive = isSearchActive,
                onSearchActiveChange = { @SuppressLint("UNUSED_VALUE")
                isSearchActive = it },
                scrollBehavior = scrollBehavior
            )
        }, content = {
            LazyColumn(
                contentPadding = it,
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                content = {
                    items(
                        items = filteredItems, key = { item -> item.name }) { item ->
                        val index = CalculatorList.allItems.indexOf(item)
                        CalculatorCard(
                            item = item, onClick = {
                                searchQuery = ""
                                @SuppressLint("UNUSED_VALUE")
                                isSearchActive = false
                                keyBoardController?.hide()
                                onCardClick(index)
                            })
                    }
                })
        })
}

@Preview
@Composable
private fun HomeScreenPreview() {
    FinCalcTheme {
        val homeListState = rememberLazyListState()
        HomeScreen(
            listState = homeListState, onCardClick = {}

        )
    }

}
