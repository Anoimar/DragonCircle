package com.thernat.dragondating

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thernat.dragondating.home.HomeScreen
import com.thernat.dragondating.login.LoginScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun DragonDatingNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = DragonDatingAppDestinations.HOME_ROUTE
) {

    NavHost(navController = navController, startDestination = startDestination) {
        composable(DragonDatingAppDestinations.LOGIN_ROUTE) {
            LoginScreen(
                onStartClick = {navController.navigate(DragonDatingAppDestinations.HOME_ROUTE)}
            )
        }
        composable(DragonDatingAppDestinations.HOME_ROUTE) {
            HomeScreen()
        }
    }
}