package com.nowni.fincalc.utils.helper

import java.text.DecimalFormat
import java.util.Locale

object FormatUtils {
    fun formatValue(value: Float, allowDecimal: Boolean): String {
        return if (allowDecimal) {
            val formatter = DecimalFormat("0.#")
            formatter.format(value)
        } else {
            value.toInt().toString()
        }

    }

        private val indianLocale = Locale.Builder().setLanguage("en").setRegion("IN").build()
        private val decimalFormat = DecimalFormat("#,##,##0", java.text.DecimalFormatSymbols(indianLocale))
        fun formatAmount(amount: Float): String = decimalFormat.format(amount.toInt())



    fun formatIndianValue(value: Float): String {
        val formatter = DecimalFormat("##,##,###")
        return formatter.format(value.toLong())

    }

//    fun formatAmount(amount: Float, locale: Locale):String{
//        val formatter = NumberFormat.getNumberInstance(locale)
//        return formatter.format(amount)
//    }


}