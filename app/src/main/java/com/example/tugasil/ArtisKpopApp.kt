package com.example.tugasil

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.core.motion.utils.Utils
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasil.`interface`.screen.home.HomeScreen
import com.example.tugasil.`interface`.screen.profile.ProfileScreen
import com.example.tugasil.`interface`.component.BottomBar
import com.example.tugasil.`interface`.navigation.Screen
import com.example.tugasil.`interface`.screen.grup.GrupScreen

@Composable
fun ArtisKpopApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route

    Scaffold(
        bottomBar = {
            for (i in com.example.tugasil.utils.Utils.listScreenWithoutBottomBar.indices) {
                if (currentRoute != com.example.tugasil.utils.Utils.listScreenWithoutBottomBar[i]) {
                    BottomBar(navController)
                }
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { artisId ->
                        navController.navigate(Screen.DetailScreen.createRoute(artisId))
                    }
                )
            }
            composable(
                route = Screen.DetailScreen.route,
                arguments = listOf(navArgument("artisId") { type = NavType.LongType }),

                ) {

            }
            composable(Screen.Grup.route){
                GrupScreen(navigateToDetail = {artisId ->
                    navController.navigate(Screen.DetailScreen.createRoute(artisId))
                })
            }

            composable(Screen.Profile.route) {
                ProfileScreen()
            }

        }
    }

}