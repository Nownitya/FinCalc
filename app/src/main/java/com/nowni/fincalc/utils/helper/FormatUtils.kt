package com.nowni.fincalc.utils.helper

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

object FormatUtils {
    fun formatValue(value: Double, allowDecimal: Boolean): String {
        return if (allowDecimal) {
            val formatter = DecimalFormat("0.#")
            formatter.format(value)
        } else {
            value.toInt().toString()
        }

    }

    private val indianLocale = Locale.Builder().setLanguage("en").setRegion("IN").build()
    private val decimalSymbols = DecimalFormatSymbols(indianLocale)

    // Full Indian grouping for currency display
    private val amountFormat = DecimalFormat("#,##,##0", decimalSymbols)

    /**
     * Formats amount with Indian numbering system:
     * 1234567.8 -> "12,34,567.8"
     * 10000.0   -> "10,000"
     */
    fun formatAmount(amount: Double): String {
        return amountFormat.format(amount)
    }

//    private val indianLocale = Locale.Builder().setLanguage("en").setRegion("IN").build()
//    private val decimalFormat =
//        DecimalFormat("#,##,##0", java.text.DecimalFormatSymbols(indianLocale))
//    fun formatAmount(amount: Float): String = decimalFormat.format(amount.toInt())



}