package com.nowni.fincalc.domain.calculator

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

enum class CalculatorCategory(val category: String) {
    INVESTMENTS("Investments"),
    GOVERNMENT("Govt & Retirement Schemes"),
    BANK_DEPOSITS("Bank Deposits & Interest"),
    LOANS("Loans & EMI"),
    TAX_SALARY("Tax & Salary"),
    OTHERS("Others / Planning")
}

sealed class CalculatorList {
    abstract val name: String
    abstract val description: String
    abstract val icon: ImageVector

    abstract val category: CalculatorCategory

    // -------- Investments --------
    object SIP : CalculatorList() {
        override val name = "SIP"
        override val description = "Calculate returns from monthly SIP investments over time."
        override val icon = Icons.Default.AccountBalance
        override val category = CalculatorCategory.INVESTMENTS
    }

    object Lumpsum : CalculatorList() {
        override val name = "Lumpsum"
        override val description = "Evaluate future value of one-time investments easily."
        override val icon = Icons.Default.AttachMoney
        override val category = CalculatorCategory.INVESTMENTS
    }

    object SWP : CalculatorList() {
        override val name = "SWP"
        override val description = "Plan monthly withdrawals from mutual fund investments smartly."
        override val icon = Icons.AutoMirrored.Filled.TrendingDown
        override val category = CalculatorCategory.INVESTMENTS
    }

    object MutualFund : CalculatorList() {
        override val name = "Mutual Fund"
        override val description = "Estimate mutual fund investment returns with compounding."
        override val icon = Icons.AutoMirrored.Filled.ShowChart
        override val category = CalculatorCategory.INVESTMENTS
    }

    object StepUpSIP : CalculatorList() {
        override val name = "Step-up SIP"
        override val description = "Plan SIPs with annual investment increment for growth."
        override val icon = Icons.AutoMirrored.Filled.TrendingUp
        override val category = CalculatorCategory.INVESTMENTS
    }

    object StockAverage : CalculatorList() {
        override val name = "Stock Average"
        override val description = "Average out stock price across multiple purchases."
        override val icon = Icons.Default.StackedLineChart
        override val category = CalculatorCategory.INVESTMENTS
    }

    object XIRR : CalculatorList() {
        override val name = "XIRR"
        override val description = "Calculate XIRR for uneven cash-flows and investments."
        override val icon = Icons.Default.Timeline
        override val category = CalculatorCategory.INVESTMENTS
    }

    object CAGR : CalculatorList() {
        override val name = "CAGR"
        override val description = "Measure compound annual growth rate of investments."
        override val icon = Icons.AutoMirrored.Filled.ShowChart
        override val category = CalculatorCategory.INVESTMENTS
    }

    // -------- Government & Retirement --------
    object SSY : CalculatorList() {
        override val name = "SSY"
        override val description = "Calculate returns from Sukanya Samriddhi Yojana deposits."
        override val icon = Icons.Default.Favorite
        override val category = CalculatorCategory.GOVERNMENT
    }

    object PPF : CalculatorList() {
        override val name = "PPF"
        override val description = "Estimate maturity and interest earned on PPF."
        override val icon = Icons.Default.AccountBalanceWallet
        override val category = CalculatorCategory.GOVERNMENT
    }

    object EPF : CalculatorList() {
        override val name = "EPF"
        override val description = "Track Employees’ Provident Fund maturity and interest."
        override val icon = Icons.Default.Savings
        override val category = CalculatorCategory.GOVERNMENT
    }

    object NPS : CalculatorList() {
        override val name = "NPS"
        override val description = "Plan retirement wealth with National Pension Scheme calculator."
        override val icon = Icons.Default.Security
        override val category = CalculatorCategory.GOVERNMENT
    }

    object APY : CalculatorList() {
        override val name = "APY"
        override val description = "Plan pension benefits under Atal Pension Yojana."
        override val icon = Icons.Default.Shield
        override val category = CalculatorCategory.GOVERNMENT
    }

    object Retirement : CalculatorList() {
        override val name = "Retirement"
        override val description = "Estimate how much money you'll need after retirement."
        override val icon = Icons.Default.Person
        override val category = CalculatorCategory.GOVERNMENT
    }

    object NSC : CalculatorList() {
        override val name = "NSC"
        override val description = "Estimate maturity value of National Savings Certificates."
        override val icon = Icons.AutoMirrored.Filled.ReceiptLong
        override val category = CalculatorCategory.GOVERNMENT
    }

    object PostOfficeMIS : CalculatorList() {
        override val name = "Post Office MIS"
        override val description = "Calculate monthly income and returns from MIS."
        override val icon = Icons.Default.MarkEmailRead
        override val category = CalculatorCategory.GOVERNMENT
    }

    object SCSS : CalculatorList() {
        override val name = "SCSS"
        override val description = "Estimate earnings from Senior Citizen Savings Scheme."
        override val icon = Icons.Default.EmojiPeople
        override val category = CalculatorCategory.GOVERNMENT
    }

    // -------- Bank Deposits --------
    object FD : CalculatorList() {
        override val name = "FD"
        override val description = "Calculate fixed deposit interest and final maturity value."
        override val icon = Icons.Default.Money
        override val category = CalculatorCategory.BANK_DEPOSITS
    }

    object RD : CalculatorList() {
        override val name = "RD"
        override val description = "Estimate interest and maturity for recurring deposits."
        override val icon = Icons.Default.Schedule
        override val category = CalculatorCategory.BANK_DEPOSITS
    }

    object SimpleInterest : CalculatorList() {
        override val name = "Simple Interest"
        override val description = "Calculate interest using principal, rate, and time."
        override val icon = Icons.Default.BarChart
        override val category = CalculatorCategory.BANK_DEPOSITS
    }

    object CompoundInterest : CalculatorList() {
        override val name = "Compound Interest"
        override val description = "Compute interest on interest for compounded returns."
        override val icon = Icons.AutoMirrored.Filled.MultilineChart
        override val category = CalculatorCategory.BANK_DEPOSITS
    }

    // -------- Loans & EMI --------
    object EMI : CalculatorList() {
        override val name = "EMI"
        override val description = "Break down loan repayments into equal monthly installments."
        override val icon = Icons.Default.Payments
        override val category = CalculatorCategory.LOANS
    }

    object VehicleLoanEMI : CalculatorList() {
        override val name = "Vehicle Loan EMI"
        override val description = "Plan EMIs for car or two-wheeler loans."
        override val icon = Icons.Default.DirectionsCar
        override val category = CalculatorCategory.LOANS
    }

    object HomeLoanEMI : CalculatorList() {
        override val name = "Home Loan EMI"
        override val description = "Calculate EMI and interest on housing loans."
        override val icon = Icons.Default.House
        override val category = CalculatorCategory.LOANS
    }

    object FlatVsReducing : CalculatorList() {
        override val name = "Flat vs Reducing"
        override val description = "Compare flat and reducing interest rate systems."
        override val icon = Icons.Default.SwapHoriz
        override val category = CalculatorCategory.LOANS
    }

    // -------- Tax & Salary --------
    object IncomeTax : CalculatorList() {
        override val name = "Income Tax"
        override val description = "Calculate annual income tax liability and tax slabs."
        override val icon = Icons.Default.Receipt
        override val category = CalculatorCategory.TAX_SALARY
    }

    object HRA : CalculatorList() {
        override val name = "HRA"
        override val description = "Calculate House Rent Allowance exemption for tax savings."
        override val icon = Icons.Default.Home
        override val category = CalculatorCategory.TAX_SALARY
    }

    object TDS : CalculatorList() {
        override val name = "TDS"
        override val description = "Estimate tax deducted at source on payments received."
        override val icon = Icons.Default.Calculate
        override val category = CalculatorCategory.TAX_SALARY
    }

    object GST : CalculatorList() {
        override val name = "GST"
        override val description = "Break down GST into CGST, SGST and IGST."
        override val icon = Icons.Default.MoneyOff
        override val category = CalculatorCategory.TAX_SALARY
    }

    object Gratuity : CalculatorList() {
        override val name = "Gratuity"
        override val description = "Estimate employee gratuity benefits based on salary."
        override val icon = Icons.Default.Work
        override val category = CalculatorCategory.TAX_SALARY
    }

    object Salary : CalculatorList() {
        override val name = "Salary"
        override val description = "View salary breakup including tax, HRA, and allowances."
        override val icon = Icons.Default.AccountBox
        override val category = CalculatorCategory.TAX_SALARY
    }

    // -------- Others --------
    object Brokerage : CalculatorList() {
        override val name = "Brokerage"
        override val description = "Calculate charges for stock trading or investment transactions."
        override val icon = Icons.AutoMirrored.Filled.TrendingFlat
        override val category = CalculatorCategory.OTHERS
    }

    object Margin : CalculatorList() {
        override val name = "Margin"
        override val description = "Find required margin for intraday or delivery trades."
        override val icon = Icons.Default.Assessment
        override val category = CalculatorCategory.OTHERS
    }

    object Inflation : CalculatorList() {
        override val name = "Inflation"
        override val description = "Understand value erosion of money due to inflation."
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

        fun findByTitle(name: String): CalculatorList? = allItems.find { it.name == name }

        fun search(query: String): List<CalculatorList> = allItems.filter {
            it.name.contains(
                query, ignoreCase = true
            ) || it.description.contains(
                query, ignoreCase = true
            )
        }

        fun groupByCategory(): Map<CalculatorCategory, List<CalculatorList>> =
            allItems.groupBy { it.category }
    }
}