package com.example.udemy_jetpackcompose_recyclerviewex.model

data class TvShow(

    val id : Int,
    val name : String,
    val year : Int,
    val rating : Double,
    val imageId : Int,
    val overview : String

) : java.io.Serializable