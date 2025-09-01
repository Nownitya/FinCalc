package com.nowni.fincalc.utils.helper

import java.text.DecimalFormat
import java.text.NumberFormat
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


    fun formatIndianValue(value: Float): String {
        val formatter = DecimalFormat("##,##,###")
        return formatter.format(value.toLong())

    }

    fun formatAmount(amount: Float, locale: Locale):String{
        val formatter = NumberFormat.getNumberInstance(locale)
        return formatter.format(amount)
    }


}