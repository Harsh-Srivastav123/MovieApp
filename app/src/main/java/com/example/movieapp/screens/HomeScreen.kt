package com.example.movieapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow


@Composable
fun HomeScreen(navController: NavController){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            Scaffold(
                topBar = {
                    TopAppBar {
                        Text(text = "Movie List",
                            style = MaterialTheme.typography.h5,

                            )
                    }
                }
            ){
                MainContent(it,navController)
            }
        }
    }
}

@Composable
fun MainContent(it: PaddingValues,navController: NavController, movieList: List<Movie> = getMovies()) {
    Surface(Modifier.padding(paddingValues = it)) {
        LazyColumn{
            items(items = movieList){
                MovieRow(it){

                    navController.currentBackStackEntry?.savedStateHandle?.set(key="movie_obj", value = it)
                   // Log.d("movie click",it.toString())
//                    navController.navigate(route = MovieScreens.DetailScreen.name+"/$it")

                    navController.navigate(route = MovieScreens.DetailScreen.name)
                }
            }
        }
    }
}

