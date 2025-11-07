package com.nowni.fincalc.utils.helper

import android.content.Context
import com.nowni.fincalc.domain.calculator.CalculatorList

fun filterCalculators(query: String, context: Context): List<CalculatorList> {
    val trimmedQuery = query.trim()
    if (trimmedQuery.isBlank()) return CalculatorList.allItems

    return CalculatorList.allItems.filter { item ->
        val name = context.getString(item.name)
        val description = context.getString(item.description)
        val category = context.getString(item.category.category)

        name.contains(trimmedQuery, ignoreCase = true) ||
                description.contains(trimmedQuery, ignoreCase = true) ||
                category.contains(trimmedQuery, ignoreCase = true)
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
