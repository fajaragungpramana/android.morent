package com.github.fajaragungpramana.morent.module.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import coil.load
import coil.transform.RoundedCornersTransformation
import com.github.fajaragungpramana.morent.common.app.AppRecyclerView
import com.github.fajaragungpramana.morent.common.app.AppRecyclerViewHolder
import com.github.fajaragungpramana.morent.databinding.ItemImageBinding

class ImageAdapter : AppRecyclerView<ItemImageBinding, String, ImageAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<String>() {

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem

    }
) {

    override fun onViewBinding(viewGroup: ViewGroup): ItemImageBinding =
        ItemImageBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

    override fun onViewHolder(itemView: View): ViewHolder = ViewHolder(itemView)

    inner class ViewHolder(itemView: View) : AppRecyclerViewHolder<String>(itemView) {

        override fun bindItem(item: String, position: Int) {
            viewBinding.aivContent.load(item) {
                transformations(RoundedCornersTransformation(16f))
            }
        }

    }

}