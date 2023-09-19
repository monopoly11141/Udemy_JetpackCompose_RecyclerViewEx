package com.example.udemy_jetpackcompose_recyclerviewex.data

import com.example.udemy_jetpackcompose_recyclerviewex.R
import com.example.udemy_jetpackcompose_recyclerviewex.model.TvShow

object TvShowList {

    val tvShows = listOf(

        TvShow(
            id = 1,
            name = "Lucifer",
            year = 2016,
            rating = 8.1,
            imageId = R.drawable.ic_launcher_foreground,
            overview = "abc"
        ),
        TvShow(
            id = 2,
            name = "123",
            year = 2012,
            rating = 8.1,
            imageId = R.drawable.ic_launcher_foreground,
            overview = "123"
        ),
        TvShow(
            id = 3,
            name = "Lucifer",
            year = 2016,
            rating = 8.1,
            imageId = R.drawable.ic_launcher_foreground,
            overview = "abc"
        ),

        )
}