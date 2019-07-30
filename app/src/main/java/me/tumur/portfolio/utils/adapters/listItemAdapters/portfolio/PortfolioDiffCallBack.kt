package me.tumur.portfolio.utils.adapters.listItemAdapters.portfolio

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import me.tumur.portfolio.repository.database.model.portfolio.PortfolioModel

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter or PagedListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */

class PortfolioDiffCallBack: DiffUtil.ItemCallback<PortfolioModel>() {
    override fun areItemsTheSame(oldItem: PortfolioModel, newItem: PortfolioModel): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: PortfolioModel, newItem: PortfolioModel): Boolean {
        return oldItem == newItem
    }

}