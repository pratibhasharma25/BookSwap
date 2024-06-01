package com.example.bookswap.navigation

import java.lang.IllegalArgumentException

enum class AppScreens {
    HomeScreen,
    GiveScreen,
    TakeScreen,
    BookDetails;
    companion object{
        fun fromRoute(route: String?): AppScreens
        = when (route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            GiveScreen.name -> GiveScreen
            TakeScreen.name -> TakeScreen
            BookDetails.name -> BookDetails
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not found")
        }
    }

}