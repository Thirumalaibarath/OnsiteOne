package com.example.on_site

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation()
{
    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = "A" )
    {
        composable(route = "A"){
            FrontPage(navController = navController)
        }
        composable(route = "B"){
            UserPage(navController = navController)
        }
    }
}