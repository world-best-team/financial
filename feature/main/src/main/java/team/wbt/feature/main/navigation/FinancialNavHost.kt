package team.wbt.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun FinancialNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = FinancialScreens.HOME.name
    ) {
        installHomeScreen {
            navController.navigateSingleToEdit()
        }
        installEditScreen {
            navController.navigateUp()
        }
    }
}

private fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

fun NavHostController.navigateSingleToHome() {
    navigateSingleTopTo(FinancialScreens.HOME.name)
}

fun NavHostController.navigateSingleToEdit() {
    navigateSingleTopTo(FinancialScreens.EDIT.name)
}