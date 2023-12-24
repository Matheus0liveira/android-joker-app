package co.tiagoaguiar.tutorial.jokerappdev.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem(val category: Category) : Item<CategoryItem.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : GroupieViewHolder(view)

    override fun createViewHolder(itemView: View): CategoryViewHolder {
        return CategoryViewHolder(itemView)
    }

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        val txtCategory = viewHolder.itemView.findViewById<TextView>(R.id.txt_category)
        val containerCategory =
            viewHolder.itemView.findViewById<LinearLayout>(R.id.container_category)
        txtCategory.text = category.name
        containerCategory.setBackgroundColor(category.bgColor.toInt())
    }

    override fun getLayout() = R.layout.item_category


}