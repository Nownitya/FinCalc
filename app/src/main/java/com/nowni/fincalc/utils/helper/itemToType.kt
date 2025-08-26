package com.nowni.fincalc.utils.helper

import com.nowni.fincalc.models.CalculatorList

internal fun itemToType(item: CalculatorList?): String? {
    return when (item) {
        is CalculatorList.SIP -> "SIP"
        is CalculatorList.Lumpsum -> "Lumpsum"
        is CalculatorList.SWP -> "SWP"
        is CalculatorList.MutualFund -> "Mutual Fund"
        is CalculatorList.SSY -> "SSY"
        is CalculatorList.PPF -> "PPF"
        is CalculatorList.EPF -> "EPF"
        is CalculatorList.FD -> "FD"
        is CalculatorList.RD -> "RD"
        is CalculatorList.NPS -> "NPS"
        is CalculatorList.HRA -> "HRA"
        is CalculatorList.Retirement -> "Retirement"
        is CalculatorList.EMI -> "EMI"
        is CalculatorList.VehicleLoanEMI -> "Vehicle Loan EMI"
        is CalculatorList.HomeLoanEMI -> "Home Loan EMI"
        is CalculatorList.SimpleInterest -> "Simple Interest"
        is CalculatorList.CompoundInterest -> "Compound Interest"
        is CalculatorList.NSC -> "NSC"
        is CalculatorList.StepUpSIP -> "Step-up SIP"
        null -> null
        else -> item.name
    }
}