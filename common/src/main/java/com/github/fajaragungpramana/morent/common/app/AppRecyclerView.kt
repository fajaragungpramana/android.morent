package com.github.fajaragungpramana.morent.common.app

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

abstract class AppRecyclerView<VB : ViewBinding, T, VH : AppRecyclerViewHolder<T>>(private val diffUtil: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, VH>(diffUtil) {

    private lateinit var _viewBinding: VB
    val viewBinding: VB
        get() = _viewBinding

    protected abstract fun onViewBinding(viewGroup: ViewGroup): VB

    protected abstract fun onViewHolder(itemView: View): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        _viewBinding = onViewBinding(parent)
        return onViewHolder(viewBinding.root)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindItem(getItem(position), position)
    }

    override fun getItemViewType(position: Int): Int = position

}