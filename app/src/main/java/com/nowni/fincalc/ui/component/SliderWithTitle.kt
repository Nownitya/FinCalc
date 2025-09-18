package com.nowni.fincalc.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices.PIXEL_4
import androidx.compose.ui.tooling.preview.Devices.PIXEL_TABLET
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.fincalc.ui.theme.FinCalcTheme
import com.nowni.fincalc.utils.helper.FormatUtils.formatValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderWithTitle(
    modifier: Modifier = Modifier,
    title: String,
    value: Float,
    onValueChange: (Float) -> Unit = {},
    minValue: Float,
    maxValue: Float,
    step: Int = 0,
    allowDecimal: Boolean = false,
    prefixIcon: @Composable (() -> Unit)? = null,
    suffixIcon: @Composable (() -> Unit)? = null,
    ) {

    //  Hold the current text in TextField
    var inputText by rememberSaveable { mutableStateOf(value.toInt().toString()) }

    //  Flag to indicate if user input is below minimum value
    var isError by rememberSaveable { mutableStateOf(false) }

    //  Update TextField whenever slider or external value changes
    LaunchedEffect(value) {
        inputText = formatValue(value, allowDecimal)
    }

    Column(modifier = modifier.padding(vertical = 8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
//            Spacer(Modifier.weight(0.5f))


            TextField(
                value = inputText,
                onValueChange = { newText ->
                    //  Allow only digit and optional decimal point
                    val sanitizedText = if (allowDecimal) {
                        newText.filter { it.isDigit() || it == '.' }
                    } else {
                        newText.filter { it.isDigit() }
                    }
                    val typedValue = sanitizedText.toFloatOrNull()
                    if (typedValue != null) {
                        //  Clamp max value but allow typing below min
                        val clampedValue = typedValue.coerceAtMost(maxValue)
                        onValueChange(clampedValue)

                        //  Preserve decimal typing if user ends with '.'
                        inputText = if (allowDecimal && sanitizedText.endsWith(".")) {
                            sanitizedText
                        } else {
                            formatValue(clampedValue, allowDecimal)
                        }

                        //  Show error if below minimum
                        isError = typedValue < minValue
                    } else {
                        inputText = sanitizedText
                        //  Show error if input is invalid but not empty
                        isError = sanitizedText.isNotEmpty()
                    }
                },
                prefix = prefixIcon,
                suffix = suffixIcon,
                leadingIcon = {
                    if (isError) {
                        Icon(
                            Icons.Default.Error,
                            contentDescription = "error",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                },
                singleLine = true,
                isError = isError,
                modifier = Modifier
//                    .weight(1f)
                    .wrapContentWidth(Alignment.End, true)
                    .widthIn(60.dp, 160.dp),
                textStyle = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.End),
                keyboardOptions = KeyboardOptions(
                    keyboardType = if (allowDecimal) KeyboardType.Decimal else KeyboardType.Number
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,

                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,

//                    errorContainerColor = Color.Red.copy(alpha = 0.1f),
                    errorContainerColor = MaterialTheme.colorScheme.errorContainer,
                    errorCursorColor = MaterialTheme.colorScheme.error,
                    cursorColor = MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(50.dp)

            )
        }

    }
    Column(modifier= Modifier
        .fillMaxWidth()
        .padding(end = 8.dp, bottom = 8.dp)
    ) {
        Slider(
            value = value,
            onValueChange = { newValue ->
                val finalValue = if (allowDecimal) newValue else newValue.toInt().toFloat()
                onValueChange(finalValue.coerceIn(minValue, maxValue))
            },
            modifier = Modifier
                .fillMaxWidth()
                .clipToBounds(),
            enabled = true,
            valueRange = minValue..maxValue,
            steps = step,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = MaterialTheme.colorScheme.outlineVariant,
                activeTickColor = MaterialTheme.colorScheme.onPrimary,
                inactiveTickColor = MaterialTheme.colorScheme.outlineVariant

            ),
        )
    }
}


@Preview(showBackground = true, showSystemUi = true, device = PIXEL_4)
@Preview(showBackground = true, showSystemUi = true, device = PIXEL_TABLET)
@Composable
private fun SliderWithTitlePreview() {
    FinCalcTheme {
        Scaffold {it->
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(20.dp)
            ) {
                var monthlyInvest by rememberSaveable { mutableFloatStateOf(25_000f) }
                var expRetRate by rememberSaveable { mutableFloatStateOf(10f) }
                var timePeriod by rememberSaveable { mutableFloatStateOf(5f) }

                SliderWithTitle(
                    title = "Monthly Investment",
                    value = monthlyInvest,
                    onValueChange = { it -> monthlyInvest = it },
                    minValue = 100f,
                    maxValue = 10_00_000f,
                    prefixIcon = { Text("₹") })

                SliderWithTitle(
                    title = "Expected Return Rate.",
                    value = expRetRate,
                    onValueChange = { it -> expRetRate = it },
                    minValue = 1f,
                    maxValue = 30f,
                    allowDecimal = true,
                    suffixIcon = { Text(" %") })

                SliderWithTitle(
                    title = "Time Period",
                    value = timePeriod,
                    onValueChange = { timePeriod = it },
                     minValue = 1f,
                    maxValue = 40f,
                    suffixIcon = { Text(" Yr") })
            }
        }
    }

}