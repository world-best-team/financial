package team.wbt.feature.main.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import team.wbt.feature.main.edit.EditRoute

fun NavGraphBuilder.installHomeScreen(
    onEditClick: () -> Unit
) {
    composable(route = FinancialScreens.HOME.name) {
        Column() {
            Text("Home Screen")
            Button(
                onClick = {
                    onEditClick()
                }
            ) {
                Text("go to Edit")
            }
        }
    }
}

fun NavGraphBuilder.installEditScreen(
    onBackClick: () -> Unit
) {
    composable(route = FinancialScreens.EDIT.name) {
        EditRoute(onBackClick = onBackClick)
    }
}