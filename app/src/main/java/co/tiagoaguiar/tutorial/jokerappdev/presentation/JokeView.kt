package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke

interface JokeView {

    fun showJoke(joke: Joke)
    fun showProgress()
    fun hideProgress()

    fun showFailure(message: String)
}