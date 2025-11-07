package com.nowni.fincalc.domain.lumpsum

import com.nowni.fincalc.domain.lumpsum.model.LumpsumResult
import kotlin.math.pow

fun computeLumpsum(
    totalInvestment: Double,
    annualRatePercentage: Double,
    timePeriod: Double,
    compoundsPerYear: Int = 1,
): LumpsumResult {
    val p = totalInvestment.coerceAtLeast(0.0)
    val r = (annualRatePercentage / 100.0)
    val n = compoundsPerYear.coerceAtLeast(1)
    val t = timePeriod.coerceAtLeast(0.0)

    // FV = P * (1 + r/n)^(n*t)
    val fv = p * (1 + r / n).pow(n * t)
    val estReturn = fv - p

    return LumpsumResult(
        investedAmount = p,
        estReturn = estReturn,
        totalValue = fv
    )


}
