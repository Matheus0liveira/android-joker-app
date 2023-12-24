package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException

class JokeRemoteDataSource {

    fun findBy(categoryName: String, callback: JokeCallback) {
        HttpClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .findBy(categoryName)
            .enqueue(
                object : Callback<Joke> {
                    override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                        if (!response.isSuccessful) {
                            callback.onError(
                                response.errorBody()?.string() ?: "Unknown Error"
                            )
                        }
                        callback.onSuccess(
                            response.body() ?: throw RuntimeException("Joke Not Found")
                        )
                    }

                    override fun onFailure(call: Call<Joke>, t: Throwable) {
                        callback.onError(t.message ?: "Internal Error")
                    }

                }
            )
    }
}