package com.nowni.fincalc.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.fincalc.domain.calculator.CalculatorCategory
import com.nowni.fincalc.domain.calculator.CalculatorList
import com.nowni.fincalc.ui.theme.FinCalcTheme

@Composable
fun CategoryCalculatorCard(
    modifier: Modifier = Modifier,
//    item: CalculatorList,
    category: CalculatorCategory,
    calculators:List<CalculatorList>,
    onClick: (CalculatorList) -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(category.category),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                modifier = Modifier.padding()
            )
            Spacer(modifier = Modifier.width(4.dp)) // small gap between text and line

            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
                    .height(0.5.dp), // thickness of the line
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
            )
        }
        LazyRow (
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(calculators) { calcItem ->
                SmallCard(item = calcItem, onClick = {onClick(calcItem)})
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallCard(
//    modifier: Modifier = Modifier,
    item: CalculatorList,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .width(120.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                item.icon, contentDescription = null,
                modifier = Modifier.sizeIn(
                    minWidth = 30.dp,
                    maxWidth = 40.dp,
                    minHeight = 30.dp,
                    maxHeight = 40.dp
                ), tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(item.name),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 14.sp,
                    letterSpacing = 0.5.sp
                ),
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis
            )


        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryCalculatorCardPreview() {
    FinCalcTheme {
        Scaffold {innerPadding->
            Column(modifier = Modifier.padding(innerPadding)) {
                val category = CalculatorCategory.INVESTMENTS
                val calculators = CalculatorList.allItems.filter { item-> item.category == category }
                CategoryCalculatorCard(
                    category = CalculatorCategory.INVESTMENTS,
                    calculators = calculators,
                    onClick = {}
                )
            }
        }
    }
}

@Preview
@Composable
fun SmallCardPreview() {
    SmallCard(
        item = CalculatorList.SIP,
        onClick = {}
    )
}

