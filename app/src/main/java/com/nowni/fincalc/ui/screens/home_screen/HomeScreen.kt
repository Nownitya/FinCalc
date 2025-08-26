package com.nowni.fincalc.ui.screens.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nowni.fincalc.models.CalculatorList
import com.nowni.fincalc.ui.component.CalculatorCard

@Composable
fun HomeScreen(
    listState: LazyListState,
    modifier: Modifier = Modifier,
    onCardClick: (index: Int) -> Unit = {},
) {
    Scaffold (
        topBar = {

        },
        content = {
            LazyColumn(
                contentPadding = it,
                state = listState,
                modifier = modifier
                    .fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                content = {
                    items(
                        items = CalculatorList.allItems,
                        key = {item -> item.name}
                    ){ item ->
                        val index = CalculatorList.allItems.indexOf(item)
                        CalculatorCard(
                            item=item,
                            onClick = {onCardClick(index)})

                    }
                }

            )
        }

    )


}