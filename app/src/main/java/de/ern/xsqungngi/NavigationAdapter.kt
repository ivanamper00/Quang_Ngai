package de.ern.xsqungngi

import android.view.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import de.ern.xsqungngi.databinding.ItemMenuBinding

class NavigationAdapter(
    listener1: Menu,
    private val listener: Listener
): RecyclerView.Adapter<NavigationAdapter.Holder>() {

    val data = listener1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_menu, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       with(holder.binding){
            menu.text = data.getItem(position).title
            val drawable = data.getItem(position).icon
           drawable?.setTint(ContextCompat.getColor(root.context, R.color.white))
           menu.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)

           root.setOnClickListener { listener.onMenuClick(data.getItem(position)) }
       }
    }

    override fun getItemCount(): Int = data.size()

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy {
            ItemMenuBinding.bind(itemView)
        }
    }

    interface Listener {
        fun onMenuClick(item: MenuItem)
    }

}