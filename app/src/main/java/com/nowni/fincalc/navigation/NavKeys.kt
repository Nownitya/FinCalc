package com.nowni.fincalc.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object Home: NavKey

@Serializable
data class CalculatorScreenKey(val type: String): NavKey
