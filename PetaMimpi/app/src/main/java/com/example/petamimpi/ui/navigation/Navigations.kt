package com.example.petamimpi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.petamimpi.ui.HomeScreen
import com.example.petamimpi.ui.profile.ProfileScreen

@Composable
fun Navigations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
    }
}