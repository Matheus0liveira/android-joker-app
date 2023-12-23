package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback) {
        val response =
            HttpClient.retrofit()
                .create(ChuckNorrisAPI::class.java)
                .findAllCategories()
                .enqueue(
                    object : Callback<List<String>> {
                        override fun onResponse(
                            call: Call<List<String>>,
                            response: Response<List<String>>
                        ) {
                            if (!response.isSuccessful) {
                                callback.onError(
                                    response.errorBody()?.string() ?: "Unknown Error"
                                )
                            }
                            callback.onSuccess(
                                response.body() ?: emptyList()
                            )

                        }

                        override fun onFailure(call: Call<List<String>>, t: Throwable) {
                            callback.onError(t.message ?: "Internal Error")
                        }

                    }
                )
    }
}