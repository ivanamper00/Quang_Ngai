package de.ern.xsqungngi.rich_luck

import com.airbnb.epoxy.EpoxyController
import de.ern.xsqungngi.rich_luck.item_model.contentItem
import de.ern.xsqungngi.rich_luck.item_model.richTitleItem

class RichController(
    private val listener: Listener
): EpoxyController() {

    var data = emptyList<RichLuckModel>()
        set(value) {
            field = value
            requestModelBuild()
        }

    private var selectedId = ""

    override fun buildModels() {
        data.forEach {
            val predicate = this@RichController.selectedId == it.title
            richTitleItem {
                id(it.title)
                title(it.title)
                selectedContent(predicate)
                onClickItem {
                    this@RichController.selectedId = if(!predicate) it.title else ""
                    this@RichController.requestModelBuild()
                }
            }
            if(predicate) it.contents.forEachIndexed { index, richContentModel ->
                contentItem {
                    id("${richContentModel.title}$index")
                    content(richContentModel)
                }
            }

        }
    }

    interface Listener {
        fun onItemSelected()
    }
}