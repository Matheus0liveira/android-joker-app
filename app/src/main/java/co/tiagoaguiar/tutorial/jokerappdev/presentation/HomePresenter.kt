package co.tiagoaguiar.tutorial.jokerappdev.presentation

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

        view.showCategories(response.map { Category(it, 0xfffafa6e) })
        view.hideProgress()
    }

}