package com.example.aroapp.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

private sealed class Screens(val route: String) {
    object Login : Screens(route = "login")
    object Signup : Screens(route = "signup")
}

@Composable
fun AuthNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screens.Login.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Screens.Login.route) {
            Login(onNavigateToSignUp = { navController.navigate(Screens.Signup.route) })
        }
        composable(route = Screens.Signup.route) {
            SignUp(onNavigateToLogin = { navController.popBackStack() })
        }
    }
}