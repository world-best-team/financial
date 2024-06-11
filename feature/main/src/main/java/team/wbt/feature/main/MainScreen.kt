package team.wbt.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import team.wbt.feature.main.navigation.FinancialNavHost

@Composable
internal fun MainScreen(
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        topBar = {
        },
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .imePadding()
            .navigationBarsPadding()
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            FinancialNavHost(navController)
        }
    }
}