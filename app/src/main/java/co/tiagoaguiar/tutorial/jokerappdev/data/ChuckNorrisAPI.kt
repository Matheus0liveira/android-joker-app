package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun findAllCategories(@Query("apiKey") apiKey: String = HttpClient.API_KEY): Call<List<String>>

    @GET("jokes/random")
    fun findRandom(
        @Query("category") category: String? = null,
        @Query("apiKey") apiKey: String = HttpClient.API_KEY,
    ): Call<Joke>
}