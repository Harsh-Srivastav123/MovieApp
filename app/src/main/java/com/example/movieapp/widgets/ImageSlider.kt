package com.example.movieapp.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.movieapp.model.getMovies

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun ImageSlider(imageList:List<String> = getMovies()[0].images){
    val pagerState= rememberPagerState()
  Box(
      Modifier
          .fillMaxWidth()
          .height(300.dp)
          .padding(10.dp)
          .clip(shape = RoundedCornerShape(15.dp)),
  contentAlignment = Alignment.Center) {
      Card(elevation = 10.dp,
      border = BorderStroke(5.dp, Color.Gray)
      ) {
          HorizontalPager(pageCount = imageList.size,
          state = pagerState,
              ) {
              Image(painter = rememberImagePainter(data =imageList[it],
                  builder = {
                      scale(Scale.FILL).crossfade(true).build()
                  }

              ), contentDescription = null)
          }
      }

  }

}