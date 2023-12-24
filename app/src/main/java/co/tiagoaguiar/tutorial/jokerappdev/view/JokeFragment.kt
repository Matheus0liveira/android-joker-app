package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.presentation.JokePresenter
import co.tiagoaguiar.tutorial.jokerappdev.presentation.JokeView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class JokeFragment : Fragment(), JokeView {
    companion object {
        const val CATEGORY_KEY = "category"
    }

    private lateinit var jokePresenter: JokePresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var txtView: TextView
    private lateinit var imgView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        jokePresenter = JokePresenter(view = this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryName = arguments?.getString(CATEGORY_KEY)

        txtView = view.findViewById(R.id.txt_joke)
        imgView = view.findViewById(R.id.img_joke)

        progressBar = view.findViewById(R.id.progress_bar)
        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = categoryName

        categoryName?.let { jokePresenter.findBy(categoryName) }


        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {

            categoryName?.let { jokePresenter.findBy(categoryName) }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun showJoke(joke: Joke) {
        txtView.text = joke.text
        Picasso.get().load(joke.iconUrl).into(imgView)


    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}