package com.complexdesign.ui.bottombar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.complexdesign.ui.HomeScreen
import com.complexdesign.ui.screens.*

@ExperimentalFoundationApi
@Composable
fun BottomNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Meditate.route) {
            Meditate()
        }
        composable(route = BottomBarScreen.Sleep.route) {
            Sleep()
        }
        composable(route = BottomBarScreen.Music.route) {
            Music()
        }
        composable(route = BottomBarScreen.Profile.route) {
            Profile()
        }
    }
}
