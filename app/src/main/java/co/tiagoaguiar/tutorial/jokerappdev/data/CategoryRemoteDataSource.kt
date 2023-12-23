package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.Category

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback) {
        val response = arrayListOf(
            "Categoria 1",
            "Categoria 2",
            "Categoria 3",
            "Categoria 4",
        )
        callback.onSuccess(response)
    }
}