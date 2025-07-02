package com.example.apirestdragonballidgs904

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DragonBallApi {
    @GET("api/characters")
    suspend fun getCharacters(): CharacterResponse

    @GET("api/characters/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Character
}

object RetrofitInstance {
    val api: DragonBallApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://dragonball-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DragonBallApi::class.java)
    }
}