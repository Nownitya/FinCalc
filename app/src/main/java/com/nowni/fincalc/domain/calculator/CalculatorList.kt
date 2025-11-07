package com.nowni.fincalc.domain.calculator

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MultilineChart
import androidx.compose.material.icons.automirrored.filled.ReceiptLong
import androidx.compose.material.icons.automirrored.filled.ShowChart
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingFlat
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.EmojiPeople
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.MarkEmailRead
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.StackedLineChart
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector
import com.nowni.fincalc.R

enum class CalculatorCategory(@StringRes val category: Int) {
    INVESTMENTS(R.string.category_investments), GOVERNMENT(R.string.category_govt_retirement), BANK_DEPOSITS(
        R.string.category_bank_deposits
    ),
    LOANS(R.string.category_loans), TAX_SALARY(R.string.category_tax_salary), OTHERS(R.string.category_others)
}

sealed class CalculatorList {
    @get:StringRes
    abstract val name: Int

    @get:StringRes
    abstract val description: Int
    abstract val icon: ImageVector

    abstract val category: CalculatorCategory

    // -------- Investments --------
    data object SIP : CalculatorList() {
        override val name = R.string.sip_name
        override val description = R.string.sip_description
        override val icon = Icons.Default.AccountBalance
        override val category = CalculatorCategory.INVESTMENTS
    }

    data object Lumpsum : CalculatorList() {
        override val name = R.string.lumpsum_name
        override val description = R.string.lumpsum_description
        override val icon = Icons.Default.AttachMoney
        override val category = CalculatorCategory.INVESTMENTS
    }

    data object SWP : CalculatorList() {
        override val name = R.string.swp_name
        override val description = R.string.swp_description
        override val icon = Icons.AutoMirrored.Filled.TrendingDown
        override val category = CalculatorCategory.INVESTMENTS
    }

    data object MutualFund : CalculatorList() {
        override val name = R.string.mutual_fund_name
        override val description = R.string.mutual_fund_description
        override val icon = Icons.AutoMirrored.Filled.ShowChart
        override val category = CalculatorCategory.INVESTMENTS
    }

    data object StepUpSIP : CalculatorList() {
        override val name = R.string.step_up_sip_name
        override val description = R.string.step_up_sip_description
        override val icon = Icons.AutoMirrored.Filled.TrendingUp
        override val category = CalculatorCategory.INVESTMENTS
    }

    data object StockAverage : CalculatorList() {
        override val name = R.string.stock_average_name
        override val description = R.string.stock_average_description
        override val icon = Icons.Default.StackedLineChart
        override val category = CalculatorCategory.INVESTMENTS
    }

    data object XIRR : CalculatorList() {
        override val name = R.string.xirr_name
        override val description = R.string.xirr_description
        override val icon = Icons.Default.Timeline
        override val category = CalculatorCategory.INVESTMENTS
    }

    data object CAGR : CalculatorList() {
        override val name = R.string.cagr_name
        override val description = R.string.cagr_description
        override val icon = Icons.AutoMirrored.Filled.ShowChart
        override val category = CalculatorCategory.INVESTMENTS
    }

    // -------- Government & Retirement --------
    data object SSY : CalculatorList() {
        override val name = R.string.ssy_name
        override val description = R.string.ssy_description
        override val icon = Icons.Default.Favorite
        override val category = CalculatorCategory.GOVERNMENT
    }

    data object PPF : CalculatorList() {
        override val name = R.string.ppf_name
        override val description = R.string.ppf_description
        override val icon = Icons.Default.AccountBalanceWallet
        override val category = CalculatorCategory.GOVERNMENT
    }

    data object EPF : CalculatorList() {
        override val name = R.string.epf_name
        override val description = R.string.epf_description
        override val icon = Icons.Default.Savings
        override val category = CalculatorCategory.GOVERNMENT
    }

    data object NPS : CalculatorList() {
        override val name = R.string.nps_name
        override val description = R.string.nps_description
        override val icon = Icons.Default.Security
        override val category = CalculatorCategory.GOVERNMENT
    }

    data object APY : CalculatorList() {
        override val name = R.string.apy_name
        override val description = R.string.apy_description
        override val icon = Icons.Default.Shield
        override val category = CalculatorCategory.GOVERNMENT
    }

    data object Retirement : CalculatorList() {
        override val name = R.string.retirement_name
        override val description = R.string.retirement_description
        override val icon = Icons.Default.Person
        override val category = CalculatorCategory.GOVERNMENT
    }

    data object NSC : CalculatorList() {
        override val name = R.string.nsc_name
        override val description = R.string.nsc_description
        override val icon = Icons.AutoMirrored.Filled.ReceiptLong
        override val category = CalculatorCategory.GOVERNMENT
    }

    data object PostOfficeMIS : CalculatorList() {
        override val name = R.string.post_office_mis_name
        override val description = R.string.post_office_mis_description
        override val icon = Icons.Default.MarkEmailRead
        override val category = CalculatorCategory.GOVERNMENT
    }

    data object SCSS : CalculatorList() {
        override val name = R.string.scss_name
        override val description = R.string.scss_description
        override val icon = Icons.Default.EmojiPeople
        override val category = CalculatorCategory.GOVERNMENT
    }

    // -------- Bank Deposits --------
    data object FD : CalculatorList() {
        override val name = R.string.fd_name
        override val description = R.string.fd_description
        override val icon = Icons.Default.Money
        override val category = CalculatorCategory.BANK_DEPOSITS
    }

    data object RD : CalculatorList() {
        override val name = R.string.rd_name
        override val description = R.string.rd_description
        override val icon = Icons.Default.Schedule
        override val category = CalculatorCategory.BANK_DEPOSITS
    }

    data object SimpleInterest : CalculatorList() {
        override val name = R.string.simple_interest_name
        override val description = R.string.simple_interest_description
        override val icon = Icons.Default.BarChart
        override val category = CalculatorCategory.BANK_DEPOSITS
    }

    data object CompoundInterest : CalculatorList() {
        override val name = R.string.compound_interest_name
        override val description = R.string.compound_interest_description
        override val icon = Icons.AutoMirrored.Filled.MultilineChart
        override val category = CalculatorCategory.BANK_DEPOSITS
    }

    // -------- Loans & EMI --------
    data object EMI : CalculatorList() {
        override val name = R.string.emi_name
        override val description = R.string.emi_description
        override val icon = Icons.Default.Payments
        override val category = CalculatorCategory.LOANS
    }

    data object VehicleLoanEMI : CalculatorList() {
        override val name = R.string.vehicle_loan_emi_name
        override val description = R.string.vehicle_loan_emi_description
        override val icon = Icons.Default.DirectionsCar
        override val category = CalculatorCategory.LOANS
    }

    data object HomeLoanEMI : CalculatorList() {
        override val name = R.string.home_loan_emi_name
        override val description = R.string.home_loan_emi_description
        override val icon = Icons.Default.House
        override val category = CalculatorCategory.LOANS
    }

    data object FlatVsReducing : CalculatorList() {
        override val name = R.string.flat_vs_reducing_name
        override val description = R.string.flat_vs_reducing_description
        override val icon = Icons.Default.SwapHoriz
        override val category = CalculatorCategory.LOANS
    }

    // -------- Tax & Salary --------
    data object IncomeTax : CalculatorList() {
        override val name = R.string.income_tax_name
        override val description = R.string.income_tax_description
        override val icon = Icons.Default.Receipt
        override val category = CalculatorCategory.TAX_SALARY
    }

    data object HRA : CalculatorList() {
        override val name = R.string.hra_name
        override val description = R.string.hra_description
        override val icon = Icons.Default.Home
        override val category = CalculatorCategory.TAX_SALARY
    }

    data object TDS : CalculatorList() {
        override val name = R.string.tds_name
        override val description = R.string.tds_description
        override val icon = Icons.Default.Calculate
        override val category = CalculatorCategory.TAX_SALARY
    }

    data object GST : CalculatorList() {
        override val name = R.string.gst_name
        override val description = R.string.gst_description
        override val icon = Icons.Default.MoneyOff
        override val category = CalculatorCategory.TAX_SALARY
    }

    data object Gratuity : CalculatorList() {
        override val name = R.string.gratuity_name
        override val description = R.string.gratuity_description
        override val icon = Icons.Default.Work
        override val category = CalculatorCategory.TAX_SALARY
    }

    data object Salary : CalculatorList() {
        override val name = R.string.salary_name
        override val description = R.string.salary_description
        override val icon = Icons.Default.AccountBox
        override val category = CalculatorCategory.TAX_SALARY
    }

    // -------- Others --------
    data object Brokerage : CalculatorList() {
        override val name = R.string.brokerage_name
        override val description = R.string.brokerage_description
        override val icon = Icons.AutoMirrored.Filled.TrendingFlat
        override val category = CalculatorCategory.OTHERS
    }

    data object Margin : CalculatorList() {
        override val name = R.string.margin_name
        override val description = R.string.margin_description
        override val icon = Icons.Default.Assessment
        override val category = CalculatorCategory.OTHERS
    }

    data object Inflation : CalculatorList() {
        override val name = R.string.inflation_name
        override val description = R.string.inflation_description
        override val icon = Icons.AutoMirrored.Filled.TrendingDown
        override val category = CalculatorCategory.OTHERS
    }

    companion object {
        val allItems = listOf(
            SIP,
            Lumpsum,
            SWP,
            MutualFund,
            SSY,
            PPF,
            EPF,
            FD,
            RD,
            NPS,
            HRA,
            Retirement,
            EMI,
            VehicleLoanEMI,
            HomeLoanEMI,
            SimpleInterest,
            CompoundInterest,
            NSC,
            StepUpSIP,
            IncomeTax,
            Gratuity,
            APY,
            CAGR,
            GST,
            FlatVsReducing,
            Brokerage,
            Margin,
            TDS,
            Salary,
            Inflation,
            PostOfficeMIS,
            SCSS,
            StockAverage,
            XIRR
        )

//        fun findByTitle(name: String, context: Context): CalculatorList? = allItems.find { context.getString(it.name) == name }
//
//        fun search(query: String, context: Context): List<CalculatorList> = allItems.filter {
//            context.getString(it.name).contains(
//                query, ignoreCase = true
//            ) || context.getString(it.description).contains(
//                query, ignoreCase = true
//            )
//        }

//        fun groupByCategory(): Map<CalculatorCategory, List<CalculatorList>> =
//            allItems.groupBy { it.category }
    }
}
