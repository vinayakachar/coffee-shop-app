package com.developer.coffeeshopapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.developer.coffeeshopapp.presentation.screens.detailsscreen.DetailsScreen
import com.developer.coffeeshopapp.presentation.screens.homescreen.HomeScreen
import com.developer.coffeeshopapp.presentation.screens.welcomescreen.WelcomeScreen

@Composable
fun NavGraph() {
    val navController=rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen){
        composable <Routes.WelcomeScreen>{
            WelcomeScreen(navController)
        }
        composable<Routes.HomeScreen>{
            HomeScreen(navController)
        }

        composable<Routes.DetailsScreen>{backStackEntry->
            val args=backStackEntry.toRoute<Routes.DetailsScreen>()
            DetailsScreen(productId=args.productId,navController)


        }

    }

}