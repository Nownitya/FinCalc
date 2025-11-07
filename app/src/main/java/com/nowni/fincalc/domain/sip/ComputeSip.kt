package com.nowni.fincalc.domain.sip

import com.nowni.fincalc.domain.sip.model.SipResult
import kotlin.math.pow

interface ComputeSip {
    fun calculateSip(
        monthlyInvestment: Double,
        expectedReturnRate: Double,
        timePeriod: Double,
    ): SipResult
}

object OrdinaryComputeSip : ComputeSip {
    override fun calculateSip(
        monthlyInvestment: Double,
        expectedReturnRate: Double,
        timePeriod: Double,
    ): SipResult {
        val months = (timePeriod * 12).toInt()
        val monthlyRate = expectedReturnRate / 100f / 12.0
        val invested = monthlyInvestment * months

        val total = if (monthlyRate > 0f) {
            monthlyInvestment* (((1+monthlyRate).pow(months.toDouble()))-1)/monthlyRate

        }else{
            invested
        }
        val estReturn = total - invested
        return SipResult(investedAmount = invested, estReturn = estReturn, totalValue = total)
    }
}

object AnnuityDueComputeSip : ComputeSip {
    override fun calculateSip(
        monthlyInvestment: Double,
        expectedReturnRate: Double,
        timePeriod: Double,
    ): SipResult {
        val months = (timePeriod * 12).toInt()
        val monthlyRate = expectedReturnRate / 100f / 12f
        val invested = monthlyInvestment * months
        val total = if (monthlyRate > 0f) {
            monthlyInvestment * (((1 + monthlyRate).pow(months.toDouble())) - 1) / monthlyRate * (1 + monthlyRate)
        } else {
            invested
        }
        val estReturn = total - invested

        return SipResult(investedAmount = invested, estReturn = estReturn, totalValue = total)
    }

}