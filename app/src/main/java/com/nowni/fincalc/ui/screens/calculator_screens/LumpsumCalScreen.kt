package com.nowni.fincalc.ui.screens.calculator_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nowni.fincalc.domain.lumpsum.computeLumpsum
import com.nowni.fincalc.ui.component.LabelValueRow
import com.nowni.fincalc.ui.component.SliderWithTitle
import com.nowni.fincalc.ui.component.TopBackButton
import com.nowni.fincalc.ui.theme.FinCalcTheme
import com.nowni.fincalc.utils.helper.FormatUtils

@Composable
fun LumpsumCalScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {

    var totalInvestment by remember { mutableFloatStateOf(25_000f) }
    var expectedReturnRate by remember { mutableFloatStateOf(12f) }
    var timePeriod by remember{mutableFloatStateOf(10f)}

    val scrollState = rememberScrollState()

    val rupeeSymbol = "₹"

    val result by remember(totalInvestment,expectedReturnRate,timePeriod) {
        derivedStateOf {
            computeLumpsum(
                totalInvestment = totalInvestment.toDouble(),
                annualRatePercentage = expectedReturnRate.toDouble(),
                timePeriod = timePeriod.toDouble(),
                compoundsPerYear = 1
            )
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 56.dp, start = 16.dp, end = 16.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SliderWithTitle(
                    title = "Total Investment",
                    value = totalInvestment,
                    onValueChange = { totalInvestment = it },
                    minValue = 500f,
                    maxValue = 1_00_00_000f,
                    prefixIcon = { Text(rupeeSymbol) },
                    modifier = Modifier.fillMaxWidth()
                )
                SliderWithTitle(
                    title = "Expected return rate (p.a)",
                    value = expectedReturnRate,
                    onValueChange = { expectedReturnRate = it },
                    minValue = 1f,
                    maxValue = 30f,
                    allowDecimal = true,
                    suffixIcon = { Text("%") },
                    modifier = Modifier.fillMaxWidth()
                )
                SliderWithTitle(
                    title = "Time Period",
                    value=timePeriod,
                    onValueChange = {timePeriod=it},
                    minValue = 1f,
                    maxValue = 40f

                )
                Spacer(modifier = Modifier.height(50.dp))

                LabelValueRow(
                    label = "Investment Amount",
                    value = "$rupeeSymbol ${FormatUtils.formatAmount(result.investedAmount)}",
                )
                LabelValueRow(
                    label = "Expected Return",
                    value = "$rupeeSymbol ${FormatUtils.formatAmount(result.estReturn)}",
                )
                LabelValueRow(
                    label = "Total Amount",
                    value = "$rupeeSymbol ${FormatUtils.formatAmount(result.totalValue)}",
                )
            }
            TopBackButton(onBack = onBack)
        }
    }
}

@Composable
fun LumpsumInputFields(
    totalInvestment: Float,
//    principal: String,
//    onPrincipalChange: (String) -> Unit,
//    rate: String,
//    onRateChange: (String) -> Unit,
//    time: String,
//    onTimeChange: (String) -> Unit,
//    onCalculate: () -> Unit
) {

}

@Preview
@Composable
private fun LumpsumCalScreenPreview() {
    FinCalcTheme {
        LumpsumCalScreen(onBack = {})
    }
}
