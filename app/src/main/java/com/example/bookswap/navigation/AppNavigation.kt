package com.example.bookswap.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookswap.model.Book
import com.example.bookswap.model.getBook
import com.example.bookswap.screens.home.BookViewModel
import com.example.bookswap.screens.home.HomeScreen
import com.example.bookswap.screens.home.give.BookDetails
import com.example.bookswap.screens.home.give.GiveScreen
import com.example.bookswap.screens.home.take.TakeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.name){
        composable(AppScreens.HomeScreen.name){
            HomeScreen(
                navController = navController)
        }
        composable(AppScreens.GiveScreen.name) {
            GiveScreen(navController = navController)
        }

        composable(AppScreens.TakeScreen.name){
            TakeScreen(navController= navController)
        }
//        composable(AppScreens.BookDetails.name+"/{book}",
//        arguments = listOf(navArgument(name = "book"){
//            type = NavType.StringType
//        })
//        ){
//            backStackEntry->
//
//            BookDetails(navController= navController, backStackEntry.arguments?.getString("book"))
//        }
    }
}

