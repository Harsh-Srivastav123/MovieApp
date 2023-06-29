package com.example.movieapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieapp.model.Movie
import com.example.movieapp.widgets.ImageSlider

@Composable
fun DetailScreen(navController: NavController, movie: Movie?){
    Surface {
        Scaffold(Modifier.fillMaxSize(),
        topBar = {
            TopAppBar {
                Row(horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.size(15.dp))
                    Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null,
                        Modifier.clickable {
                            navController.popBackStack()
                        })
                    Spacer(modifier = Modifier.size(100.dp))
                    Text(text = "Movie",
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
        Column(
            Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState())) {


           if(movie!=null){
               ImageSlider(movie.images)
               Spacer(modifier = Modifier.size(15.dp))
               Text(text = movie.title,
                   style = MaterialTheme.typography.h3,
               fontWeight = FontWeight.Bold)
               Spacer(modifier = Modifier.size(10.dp))
               Text(text = movie.plot,
                   style = MaterialTheme.typography.h6)
               Spacer(modifier = Modifier.size(10.dp))
               Text(buildAnnotatedString {
                   withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 18.sp)){
                       append("Actor: ")
                   }
                   withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 18.sp, fontWeight = FontWeight.Bold)){
                       append(movie.actors)
                   }

               })
               Spacer(modifier = Modifier.size(10.dp))
               Text(buildAnnotatedString {
                   withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 18.sp)){
                       append("Director: ")
                   }
                   withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 18.sp, fontWeight = FontWeight.Bold)){
                       append(movie.director)
                   }

               })
               Spacer(modifier = Modifier.size(10.dp))
               Text(buildAnnotatedString {
                   withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 18.sp)){
                       append("Rating: ")
                   }
                   withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 18.sp, fontWeight = FontWeight.Bold)){
                       append(movie.rating)
                   }

               })
               Spacer(modifier = Modifier.size(10.dp))
               Text(buildAnnotatedString {
                   withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 18.sp)){
                       append("Released Year: ")
                   }
                   withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 18.sp, fontWeight = FontWeight.Bold)){
                       append(movie.year)
                   }

               })
               Spacer(modifier = Modifier.size(10.dp))
               Text(buildAnnotatedString {
                   withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 18.sp)){
                       append("Genre: ")
                   }
                   withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 18.sp, fontWeight = FontWeight.Bold)){
                       append(movie.genre)
                   }

               })

           }
        }
    }
}
