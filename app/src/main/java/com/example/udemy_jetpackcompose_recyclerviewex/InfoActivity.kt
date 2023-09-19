package com.example.udemy_jetpackcompose_recyclerviewex

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.udemy_jetpackcompose_recyclerviewex.model.TvShow


class InfoActivity : ComponentActivity() {

    companion object {
        private const val TVSHOWID = "tvshowid"
        fun intent(context: Context, tvShow: TvShow) = Intent(context, InfoActivity::class.java).apply {
            putExtra(TVSHOWID, tvShow)
        }
    }

    private val tvShow: TvShow by lazy {
        intent?.getSerializableExtra(TVSHOWID) as TvShow
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewMoreInfo(tvShow = tvShow)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewMoreInfo(tvShow: TvShow) {

    val scrollState = rememberScrollState()

    Card(
        modifier = Modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = tvShow.imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = tvShow.name,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = tvShow.overview,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Original Release : ${tvShow.year}",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "IMBD Rating : ${tvShow.rating}",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }

}