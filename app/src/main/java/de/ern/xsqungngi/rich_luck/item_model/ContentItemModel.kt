package de.ern.xsqungngi.rich_luck.item_model

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import de.ern.xsqungngi.R
import de.ern.xsqungngi.databinding.ItemRichContentBinding
import de.ern.xsqungngi.rich_luck.RichContentModel

@EpoxyModelClass(
    layout = R.layout.item_rich_content
)
abstract class ContentItemModel: EpoxyModelWithHolder<ContentItemModel.Holder>() {

    @EpoxyAttribute
    var content: RichContentModel? = null

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(holder.binding){
            backgroundContent.setBackgroundResource(content?.backgroundRes ?: 0)
            contentImage.setBackgroundResource(content?.imageRes ?: 0)
            contentTitle.text = content?.title
            contentPrize.text = content?.price
            contentDescription.text = content?.desc
            contentDescription2.text = content?.desc2
            contentDescription3.text = content?.desc3
            contentDescription4.text = content?.time
        }
    }

    class Holder : EpoxyHolder(){
        lateinit var binding: ItemRichContentBinding
        override fun bindView(itemView: View) {
            binding = ItemRichContentBinding.bind(itemView)
        }
    }

}