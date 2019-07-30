package me.tumur.portfolio.utils.adapters.listItemAdapters.portfolio.button

import androidx.recyclerview.widget.RecyclerView
import me.tumur.portfolio.repository.database.model.button.ButtonModel

/**
 * Sealed class for composited list data
 * to differentiate [ButtonOutlineViewHolder] and [ButtonNormalViewHolder]
 * for [RecyclerView]
 * */
sealed class ButtonItem {
    data class ButtonOutline(val outline: ButtonModel) : ButtonItem() {
        override val id = outline.id
    }

    data class ButtonNormal(val normal: ButtonModel) : ButtonItem() {
        override val id = normal.id
    }

    abstract val id: String
}