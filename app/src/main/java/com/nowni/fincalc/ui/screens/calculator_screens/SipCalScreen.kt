package com.nowni.fincalc.ui.screens.calculator_screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nowni.fincalc.ui.component.LabelValueRow
import com.nowni.fincalc.ui.component.SliderWithTitle
import com.nowni.fincalc.ui.theme.FinCalcTheme
import com.nowni.fincalc.utils.helper.FormatUtils
import kotlin.math.pow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SipCalScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    var monthlyInvestment by remember { mutableFloatStateOf(25_000f) }
    var expectedReturn by remember { mutableFloatStateOf(12f) }
    var timePeriod by remember { mutableFloatStateOf(10f) }

    val rupeeSymbol = "₹"


    val months by remember(timePeriod) {
        derivedStateOf { (timePeriod * 12).toInt() }
    }

    val futureValue by remember(monthlyInvestment, expectedReturn, timePeriod) {
        derivedStateOf {
            val monthlyRate = expectedReturn / 100 / 12
            if (monthlyRate > 0) {
                monthlyInvestment * ((1 + monthlyRate).pow(months) - 1) / monthlyRate * (1 + monthlyRate)
            } else {
                monthlyInvestment * months
            }
        }
    }

    val investedAmount by remember(monthlyInvestment, timePeriod) {
        derivedStateOf {
            monthlyInvestment * months
        }
    }

    val estReturn by remember(futureValue, investedAmount) {
        derivedStateOf {
            futureValue - investedAmount
        }
    }

    val scrollState = rememberScrollState()
    Scaffold {
        Box(
            modifier = modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .shadow(10.dp, RoundedCornerShape(25.dp))
                        .size(40.dp)
                        .clip(CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back Button",
                        tint = MaterialTheme.colorScheme.onSurface
                    )


                }
            }
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(top = 56.dp, start = 16.dp, end = 16.dp)
            ) {
                SliderWithTitle(
                    title = "Monthly Investment",
                    value = monthlyInvestment,
                    onValueChange = { monthlyInvestment = it },
                    minValue = 100f,
                    maxValue = 10_00_000f,
                    prefixIcon = { Text(rupeeSymbol) },
                )
                SliderWithTitle(
                    title = "Expected Return (p.a)",
                    value = expectedReturn,
                    onValueChange = { expectedReturn = it },
                    minValue = 1f,
                    maxValue = 30f,
                    allowDecimal = true,
                    suffixIcon = { Text("%") },
                )
                SliderWithTitle(
                    title = "Time Period",
                    value = timePeriod,
                    onValueChange = { timePeriod = it },
                    minValue = 1f,
                    maxValue = 40f,
                    suffixIcon = { Text("Yr") },
                )

                Spacer(modifier = Modifier.height(50.dp))

                LabelValueRow(
                    label = "Investment Amount",
                    value = "$rupeeSymbol ${FormatUtils.formatAmount(investedAmount)}",
                )
                LabelValueRow(
                    label = "Expected Return",
                    value = "$rupeeSymbol ${FormatUtils.formatAmount(estReturn)}",
                )
                LabelValueRow(
                    label = "Total Amount",
                    value = "$rupeeSymbol ${FormatUtils.formatAmount(futureValue)}",
                )
            }
        }
    }
}

@Preview(
    showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun SipCalScreenPreview() {
    FinCalcTheme {
        SipCalScreen(modifier = Modifier.padding(), {})
    }
}