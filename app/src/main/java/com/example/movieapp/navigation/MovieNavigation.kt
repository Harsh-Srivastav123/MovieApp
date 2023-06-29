package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.model.Movie
import com.example.movieapp.screens.DetailScreen
import com.example.movieapp.screens.HomeScreen

@Composable
fun MovieNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination =MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }
//        composable(MovieScreens.DetailScreen.name,
//        arguments = listOf(navArgument(name = "movie"){
//            type= NavType.StringType
//        })
//        ){
//            DetailScreen(navController = navController,it.arguments?.getString("movie"))
//        }
        composable(MovieScreens.DetailScreen.name){
            val movieObj=navController.previousBackStackEntry?.savedStateHandle?.get<Movie>("movie_obj")
            DetailScreen(navController = navController, movie =movieObj )
        }
    }
}