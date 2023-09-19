package com.example.udemy_jetpackcompose_recyclerviewex

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.udemy_jetpackcompose_recyclerviewex.data.TvShowList
import com.example.udemy_jetpackcompose_recyclerviewex.model.TvShow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import com.example.udemy_jetpackcompose_recyclerviewex.compose.TvShowListItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayTvShows{
                startActivity(InfoActivity.intent(this, it))
            }
        }
    }
}

//@Composable
//fun ScrollableColumn() {
//    val scrollState = rememberScrollState()
//    Column(
//        modifier = Modifier.verticalScroll(scrollState)
//    ) {
//        for (i in 1..100) {
//            Text(
//                "User name $i",
//                style = MaterialTheme.typography.headlineMedium,
//                modifier = Modifier.padding(10.dp)
//            )
//            Divider(
//                color = Color.Black,
//                thickness = 5.dp
//            )
//        }
//    }
//}

//@Composable
//fun LazyColumn(selectedItem: (String) -> (Unit)) {
//    androidx.compose.foundation.lazy.LazyColumn {
//        items(100) {
//            Text(
//                "User name $it",
//                style = MaterialTheme.typography.headlineMedium,
//                modifier = Modifier.padding(10.dp)
//                    .clickable{selectedItem("$it selected")}
//            )
//            Divider(
//                color = Color.Black,
//                thickness = 5.dp
//            )
//        }
//    }
//}


@Composable
fun DisplayTvShows(onTvShowItemClicked: (TvShow) -> Unit) {
    val tvShows = remember { TvShowList.tvShows }

    LazyColumn(
        contentPadding = PaddingValues(16.dp, 8.dp),
    ) {
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, onTvShowItemClicked)
            }
        )
    }
}