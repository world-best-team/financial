package team.wbt.feature.main.edit

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import team.wbt.feature.main.edit.components.EditTopBar

@Composable
fun EditScreen() {
    Scaffold(
        topBar = {
            EditTopBar(
                modifier = Modifier
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .imePadding()
            .navigationBarsPadding()
    ) { paddingValues ->

    }
}