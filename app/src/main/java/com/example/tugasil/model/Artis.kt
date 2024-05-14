package com.example.tugasil.model

data class Artis(
    val id: Int,
    val name: String,
    val descrip: String,
    val image: Int,
    val isTop: Boolean? = false,
    val isSolo : Boolean? = false
)