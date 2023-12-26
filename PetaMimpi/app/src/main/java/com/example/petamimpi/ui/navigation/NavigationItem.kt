package com.example.petamimpi.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, val icon: ImageVector?, var title: String) {
    object Home : NavigationItem("Home", Icons.Rounded.Home, "Home")
    object Profile : NavigationItem("Profile", Icons.Rounded.Person, "Profile")
}