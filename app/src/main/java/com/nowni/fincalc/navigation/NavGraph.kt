package com.nowni.fincalc.navigation

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.nowni.fincalc.models.CalculatorList
import com.nowni.fincalc.ui.screens.calculator_screens.SipCalScreen
import com.nowni.fincalc.ui.screens.home_screen.HomeScreen
import com.nowni.fincalc.utils.helper.itemToType

@Composable
fun AppNavGraph() {

//    val backStack = remember { mutableStateListOf<NavKey>(Home) }
    val backStack: SnapshotStateList<NavKey> = rememberNavBackStack(Home)
    val homeListState = rememberLazyListState()

    val entryDecorators = listOf(
        rememberSavedStateNavEntryDecorator(),
//        rememberViewModelStoreNavEntryDecorator(),
        rememberSceneSetupNavEntryDecorator()
    )


    val entryProvider: (NavKey) -> NavEntry<NavKey> = entryProvider {
        entry<Home> {
            HomeScreen(
                listState = homeListState, onCardClick = { index ->
                    val item = CalculatorList.allItems.getOrNull(index)
                    val type = itemToType(item)

                    type?.let { backStack.add(CalculatorScreenKey(it)) }
                }
            )
        }
        entry<CalculatorScreenKey> { key ->
            when (key.type) {
                "SIP" -> SipCalScreen(onBack = {
                    if (backStack.size > 1) backStack.removeLastOrNull()
                }
                )

                "Lumpsum" -> {}
                "SWP" -> {}
                "Mutual Fund" -> {}
                else -> {}
            }
        }
    }

    NavDisplay(
        backStack = backStack,
        entryDecorators = entryDecorators,
        onBack = { if (backStack.size > 1) backStack.removeLastOrNull() },
        entryProvider = entryProvider,
    )
}