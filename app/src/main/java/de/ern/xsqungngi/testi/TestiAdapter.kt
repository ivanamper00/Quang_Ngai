package de.ern.xsqungngi.testi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.ern.xsqungngi.Data
import de.ern.xsqungngi.R
import de.ern.xsqungngi.databinding.ItemTestiBinding

class TestiAdapter: RecyclerView.Adapter<TestiAdapter.Holder>() {

    val data = Data.testi

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_testi, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(holder.binding){
            val user = data[position]
            userImage.setImageResource(user.userImage)
            userName.text = user.userName
            userTesti.text = user.userTesti
            userRating.rating = user.userRating.toFloat()
            dateComented.text = user.dateCommented
        }
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        val binding by lazy {
            ItemTestiBinding.bind(itemView)
        }
    }

}