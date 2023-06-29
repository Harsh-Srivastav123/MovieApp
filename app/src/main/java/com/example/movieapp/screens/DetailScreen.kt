package com.example.movieapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.model.Movie

@Composable
fun DetailScreen(navController: NavController, movie: Movie?){
    Surface {
        Scaffold(Modifier.fillMaxSize(),
        topBar = {
            TopAppBar {
                Row(horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.size(10.dp))
                    Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null,
                        Modifier.clickable {
                            navController.popBackStack()
                        })
                    Spacer(modifier = Modifier.size(100.dp))
                    Text(text = "movie",
                        style = MaterialTheme.typography.h4)
                }
            }
        }) {
            DetailsContent(it,movie)
        }
    }
}

@Composable
fun DetailsContent(it: PaddingValues,movie: Movie?) {
    Surface(Modifier.padding(paddingValues = it)) {
        Column(Modifier.padding(10.dp)) {

           if(movie!=null){
               Text(text = movie.title,
                   style = MaterialTheme.typography.h5)

               Text(text = movie.actors,
                   style = MaterialTheme.typography.h5)
           }
        }
    }
}
