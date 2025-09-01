package com.nowni.fincalc.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SeekBarWithTitle(
    modifier: Modifier = Modifier,
    title: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    enabled: Boolean = true,
    ) {


}