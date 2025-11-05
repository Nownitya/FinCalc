package com.nowni.fincalc.utils.helper

import com.nowni.fincalc.domain.calculator.CalculatorList

fun filterCalculators(query: String): List<CalculatorList> {
    val trimmedQuery = query.trim()
    if (trimmedQuery.isBlank()) return CalculatorList.allItems

    return CalculatorList.allItems.filter { item ->
        item.name.contains(trimmedQuery, ignoreCase = true) ||
                item.description.contains(trimmedQuery, ignoreCase = true)
    }
}


/*
val filteredItems = remember(searchQuery) {
    if (searchQuery.isBlank()) {
        CalculatorList.allItems
    } else {
        CalculatorList.allItems.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        }
    }
}*/
