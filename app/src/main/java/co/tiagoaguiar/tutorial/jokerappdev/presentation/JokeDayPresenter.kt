package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.data.JokeCallback
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeDayRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke

class JokeDayPresenter(
    private val view: JokeDayView,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource(),
) : JokeCallback {

    fun findRandom() {
        view.showProgress()
        dataSource.findRandom(this)
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