package com.nowni.fincalc.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nowni.fincalc.domain.calculator.CalculatorList
import com.nowni.fincalc.ui.theme.FinCalcTheme

@Composable
fun CalculatorCard(
    item: CalculatorList,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,

    ) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 100.dp)
            .wrapContentSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(), content = {
                    Text(
                        stringResource(item.name),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 16.dp)
                    )
                    Text(
                        text = stringResource(item.description),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                        maxLines = 5,
                        modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 8.dp)
                    )
                    Spacer(Modifier.height(12.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.BottomEnd,
                        content = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(80.dp),
                            )
                        })
                })
        })
}


@Preview(
    showBackground = true, name = "Calculator Card Light", uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun CalculatorCardPreview() {
    FinCalcTheme {
        CalculatorCard(item = CalculatorList.SIP, onClick = {})

    }

}