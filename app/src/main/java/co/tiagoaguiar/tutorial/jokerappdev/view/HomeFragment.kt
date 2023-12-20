package co.tiagoaguiar.tutorial.jokerappdev.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = view.findViewById<RecyclerView>(R.id.rv_main)

        val adapter = GroupieAdapter()
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter


        adapter.add(CategoryItem(Category("Categoria 1", 0xfffafa6e)))
        adapter.add(CategoryItem(Category("Categoria 2", 0xffe0f470)))
        adapter.add(CategoryItem(Category("Categoria 3", 0xffc7ed73)))
        adapter.add(CategoryItem(Category("Categoria 4", 0xffaee678)))

        adapter.notifyDataSetChanged()


    }
}