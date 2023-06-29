package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies







@Composable
fun MovieRow(movie: Movie, onMovieClick:(Movie)->Unit={}) {
    val expanded =remember{
        mutableStateOf(false)
    }
    Card(
        Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onMovieClick(movie)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(
                Modifier
                    .padding(10.dp)
                    .size(100.dp), elevation = 4.dp,
                shape = RectangleShape
            ) {
                Image(painter = rememberImagePainter(data =movie.images[0],
                    builder  ={
                        crossfade(true)
                            transformations(CircleCropTransformation())
                }

                    ), contentDescription = null)
            }
            Column(Modifier.padding(4.dp)) {

                Text(text = movie.title,
                style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "Director: ${movie.director}",
                style = MaterialTheme.typography.caption)
                Text(text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.caption)


                AnimatedVisibility(visible = expanded.value) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp)){
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp, fontWeight = FontWeight.Bold)){
                                append(movie.plot)
                            }

                        })
                        Spacer(modifier = Modifier.size(5.dp))

                        Divider()
                        Text(text = "Director: ${movie.director}", fontSize = 13.sp,
                        fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(text = "Actors: ${movie.actors}", fontSize = 13.sp,
                            fontWeight = FontWeight.Bold)
                        
                    }
                }


                Icon(imageVector =if (expanded.value)  Icons.Rounded.KeyboardArrowUp else  Icons.Rounded.ArrowDropDown , contentDescription = null,Modifier.clickable {


                    //action on click
                    expanded.value=!expanded.value
                })
                
            }

        }
    }
}