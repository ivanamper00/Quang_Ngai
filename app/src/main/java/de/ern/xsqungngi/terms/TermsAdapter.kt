package de.ern.xsqungngi.terms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.ern.xsqungngi.Data
import de.ern.xsqungngi.R
import de.ern.xsqungngi.databinding.ItemTermsBinding

class TermsAdapter: RecyclerView.Adapter<TermsAdapter.Holder>() {

    private val data = Data.terms

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy {
            ItemTermsBinding.bind(itemView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermsAdapter.Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_terms, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: TermsAdapter.Holder, position: Int) {
        with(holder.binding){
            val termsItem = data[position]
            termsTitle.text = termsItem.title
            termsDesc.text = termsItem.desc
        }
    }

    override fun getItemCount(): Int = data.size
}