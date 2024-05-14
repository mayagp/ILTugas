package com.example.tugasil.`interface`.navigation

sealed class Screen(val route : String) {
    object Home : Screen("home")

    object Profile : Screen("profile")
    object DetailScreen : Screen("home/{menuId}"){
        fun createRoute(artisId : Long) = "home/$artisId"
    }
    object Grup : Screen("grup")
}