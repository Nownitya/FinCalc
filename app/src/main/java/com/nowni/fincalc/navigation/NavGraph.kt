package com.nowni.fincalc.navigation

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.nowni.fincalc.domain.calculator.CalculatorList
import com.nowni.fincalc.ui.screens.calculator_screens.SipCalScreen
import com.nowni.fincalc.ui.screens.home_screen.HomeScreen
import com.nowni.fincalc.utils.helper.itemToType

@Composable
fun AppNavGraph() {

    val backStack: NavBackStack<NavKey> = rememberNavBackStack(Home)
    val homeListState = rememberLazyListState()

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

//        entryDecorators = entryDecorators,
        onBack = { if (backStack.size > 1) backStack.removeLastOrNull() },
        entryProvider = entryProvider,
    )
}