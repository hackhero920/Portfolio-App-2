package me.tumur.portfolio.utils.adapters.listItemAdapters.portfolio.screenshot

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import me.tumur.portfolio.repository.database.model.screenshot.ScreenShotModel

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter or PagedListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */

class ScreenShotDiffCallBack : DiffUtil.ItemCallback<ScreenShotModel>() {
    override fun areItemsTheSame(oldItem: ScreenShotModel, newItem: ScreenShotModel): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ScreenShotModel, newItem: ScreenShotModel): Boolean {
        return oldItem == newItem
    }

}