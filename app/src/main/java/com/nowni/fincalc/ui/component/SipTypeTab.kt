package com.nowni.fincalc.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nowni.fincalc.domain.sip.model.SipType

@Composable
fun SipTypeTab(
    modifier: Modifier = Modifier,
    selectedType: SipType,
    onTabSelected: (Int) -> Unit,
    ) {

    val types = SipType.values()
//    SecondaryTabRow(selectedTabIndex = types.indexOf(selectedType)) {
//        types.forEachIndexed { index, type ->
//            Tab(
//                selectedType = selectedType == type,
//                onClick = { onTabSelected(type) },
//                text = Text(type.title) ,
//                selected = {},
////                selectedContentColor = TODO(),
////                unselectedContentColor = TODO()
//            ) { }
//        }
//    }
}