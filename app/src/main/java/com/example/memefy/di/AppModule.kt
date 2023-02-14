package com.example.memefy.di

import com.example.memefy.Model.Getmemes.MemesApi
import com.example.memefy.Model.Getmemes.MemesApiImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {




        @Provides //tells dagger hilt this is a recipe ;)
        @Singleton //only one instance will be shared between our viewModels
        fun provideKtorClient(): HttpClient {
            val client: HttpClient = HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
            return client
    }

    @Provides
    @Singleton
    fun providePostApi(httpClient: HttpClient): MemesApi {
        return MemesApiImp(httpClient)
    }

}