package com.nowni.fincalc.domain.sip

import com.nowni.fincalc.domain.sip.model.SipResult
import kotlin.math.pow

sealed class SipCalculator {
    abstract fun calculateFutureValue(
        monthlyInvestment: Float,
        expectedReturn: Float,
        timePeriod: Float,
    ): SipResult
}

object OrdinarySipCalculator : SipCalculator() {
    override fun calculateFutureValue(
        monthlyInvestment: Float,
        expectedReturn: Float,
        timePeriod: Float,
    ): SipResult {
        val months = (timePeriod * 12).toInt()
        val monthlyRate = expectedReturn / 100 / 12
        val invested = monthlyInvestment * months

        val total = if (monthlyRate == 0f) {
            monthlyInvestment * ((1 + monthlyRate).pow(months) - 1) / monthlyRate
        } else {
            invested
        }
        val estReturn = total - invested

        return SipResult(
            investedAmount = invested,
            estReturn = estReturn,
            totalValue = total
        )
    }

}

object AnnuityDueSipCalculator : SipCalculator() {
    override fun calculateFutureValue(
        monthlyInvestment: Float,
        expectedReturn: Float,
        timePeriod: Float,
    ): SipResult {
        val months = (timePeriod * 12).toInt()
        val monthlyRate = expectedReturn / 100 / 12

        val invested = monthlyInvestment * months
        val total = if (monthlyRate > 0) {
            monthlyInvestment * ((1 + monthlyRate).pow(months) - 1) / monthlyRate * (1 + monthlyRate)
        } else {
            invested
        }
        val estReturn = total - invested

        return SipResult(
            investedAmount = invested,
            estReturn = estReturn,
            totalValue = total
        )
    }

}