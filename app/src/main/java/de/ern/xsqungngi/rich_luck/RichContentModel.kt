package de.ern.xsqungngi.rich_luck

import de.ern.xsqungngi.R

data class RichContentModel(
    val imageRes: Int = R.drawable.default_content,
    val backgroundRes: Int,
    val title: String,
    val price: String = "đ 1,500.00",
    val time: String,
    val desc: String,
    val desc2: String,
    val desc3: String
)
