package com.example.memefy.Model.Getmemes


import kotlinx.serialization.Serializable

@Serializable
data class Meme(
    val title: String?,
    val url: String?
)