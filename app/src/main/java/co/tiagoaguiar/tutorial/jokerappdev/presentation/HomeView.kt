package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.model.Category

interface HomeView {

    fun showCategories(categories: List<Category>)
    fun showProgress()
    fun hideProgress()

    fun showFailure(message: String)
}