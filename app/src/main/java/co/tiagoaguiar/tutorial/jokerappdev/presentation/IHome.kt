package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem

interface IHome {

    fun showCategories(categories: List<CategoryItem>)
    fun showProgress()
    fun hideProgress()

    fun showFailure(message: String)
}