package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.data.JokeCallback
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke

class JokePresenter(
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource(),
    private val view: JokeView
) : JokeCallback {

    fun findBy(categoryName: String) {
        view.showProgress()
        dataSource.findBy(categoryName, this)
    }

    override fun onError(response: String) {
        view.showFailure(response)
        view.hideProgress()
    }

    override fun onComplete() {
        view.hideProgress()
    }

    override fun onSuccess(response: Joke) {
        view.showJoke(response)
        view.hideProgress()
    }
}