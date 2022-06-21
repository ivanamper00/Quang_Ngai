package de.ern.xsqungngi.rich_luck.item_model

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import de.ern.xsqungngi.R
import de.ern.xsqungngi.databinding.ItemRichContentBinding
import de.ern.xsqungngi.databinding.ItemTitleCardBinding
import de.ern.xsqungngi.rich_luck.RichContentModel

@EpoxyModelClass(
    layout = R.layout.item_title_card
)
abstract class RichTitleItemModel: EpoxyModelWithHolder<RichTitleItemModel.Holder>() {

    @EpoxyAttribute
    var title: String? = null

    @EpoxyAttribute
    var selectedContent: Boolean = false

    @EpoxyAttribute
    var onClickItem: (()->Unit)? = null

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(holder.binding){
            richTitle.text = title
            selector.rotation = if(selectedContent) -90F else 0F
            root.setOnClickListener {
                onClickItem?.invoke()
            }
        }
    }

    class Holder : EpoxyHolder(){
        lateinit var binding: ItemTitleCardBinding
        override fun bindView(itemView: View) {
            binding = ItemTitleCardBinding.bind(itemView)
        }
    }

}