package com.nowni.fincalc.domain.sip

import com.nowni.fincalc.domain.sip.model.SipResult
import kotlin.math.pow

interface SipCalculator {
    fun calculateSip(
        monthlyInvestment: Float,
        expectedReturnRate: Float,
        timePeriod: Float,
    ): SipResult
}

object OrdinarySipCalculator : SipCalculator {
    override fun calculateSip(
        monthlyInvestment: Float,
        expectedReturnRate: Float,
        timePeriod: Float,
    ): SipResult {
        val months = (timePeriod * 12).toInt()
        val monthlyRate = expectedReturnRate / 100f / 12f
        val invested = monthlyInvestment * months

        val total = if (monthlyRate > 0f) {
            monthlyInvestment* (((1+monthlyRate).pow(months.toFloat()))-1)/monthlyRate

        }else{
            invested
        }
        val estReturn = total - invested
        return SipResult(investedAmount = invested, estReturn = estReturn, totalValue = total)
    }
}

object AnnuityDueSipCalculator : SipCalculator {
    override fun calculateSip(
        monthlyInvestment: Float,
        expectedReturnRate: Float,
        timePeriod: Float,
    ): SipResult {
        val months = (timePeriod * 12).toInt()
        val monthlyRate = expectedReturnRate / 100f / 12f
        val invested = monthlyInvestment * months
        val total = if (monthlyRate > 0f) {
            monthlyInvestment * (((1 + monthlyRate).pow(months.toFloat())) - 1) / monthlyRate * (1 + monthlyRate)
        } else {
            invested
        }
        val estReturn = total - invested

        return SipResult(investedAmount = invested, estReturn = estReturn, totalValue = total)
    }

}