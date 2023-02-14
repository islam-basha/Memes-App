package com.example.memefy.Model.Getmemes

import com.example.memefy.util.Routes
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class MemesApiImp (
    private val client: HttpClient
    ): MemesApi {

        override suspend fun getMemes(): Meme {
               return client.get {
                    url(Routes.Memes)
                }.body()

        }
}