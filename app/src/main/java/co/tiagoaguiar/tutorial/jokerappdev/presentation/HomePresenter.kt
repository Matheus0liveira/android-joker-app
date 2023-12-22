package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem

class HomePresenter(private val view: IHome) {
    fun findAllCategories() {
        view.showProgress()
        fakeRequest()

    }

    private fun onError(message: String) {
        view.showFailure(message)
        view.hideProgress()
    }

    private fun onSuccess(response: List<Category>) {

        view.showCategories(response.map { CategoryItem(it) })
        view.hideProgress()
    }


    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                Category("Categoria 1", 0xfffafa6e),
                Category("Categoria 2", 0xffe0f470),
                Category("Categoria 3", 0xffc7ed73),
                Category("Categoria 4", 0xffaee678),
            )
//            onSuccess(response)
            onError("FERROU TUDO PAIÇEIRU")
        }, 2000)
    }
}