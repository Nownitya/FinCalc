package com.nowni.fincalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nowni.fincalc.navigation.AppNavGraph
import com.nowni.fincalc.ui.theme.FinCalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinCalcTheme {
                AppNavGraph()
            }
        }
    }
}
