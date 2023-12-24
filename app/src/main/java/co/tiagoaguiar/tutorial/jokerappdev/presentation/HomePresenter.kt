package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.graphics.Color
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListCategoryCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem

class HomePresenter(
    private val view: HomeView,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {
    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)

    }


    override fun onError(response: String) {
        view.showFailure(response)
        view.hideProgress()
    }

    override fun onComplete() {
        view.hideProgress()
    }

    override fun onSuccess(response: List<String>) {
        val start = 40
        val end = 190
        val diff = (end - start) / response.size


        view.showCategories(response.mapIndexed { index, value ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                100.0f
            )

            Category(value, Color.HSVToColor(hsv).toLong())
        })
        view.hideProgress()
    }

}