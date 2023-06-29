package com.example.movieapp.navigation

enum class MovieScreens {
    HomeScreen,
    DetailScreen;
    companion object{
        fun fromRoute(route:String?):MovieScreens{
            return when(route?.substringBefore("/")){
                HomeScreen.name->HomeScreen
                DetailScreen.name->DetailScreen
                null->HomeScreen
                else->throw java.lang.IllegalArgumentException("Route $route is not recognized")
            }
        }
    }
}