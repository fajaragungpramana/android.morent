package com.github.fajaragungpramana.morent.module.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import coil.transform.RoundedCornersTransformation
import com.github.fajaragungpramana.morent.common.app.AppRecyclerView
import com.github.fajaragungpramana.morent.common.app.AppRecyclerViewHolder
import com.github.fajaragungpramana.morent.core.domain.house.model.House
import com.github.fajaragungpramana.morent.databinding.ItemHouseBinding

class HouseAdapter :
    AppRecyclerView<ItemHouseBinding, House, HouseAdapter.ViewHolder>(House.diffUtil) {

    override fun onViewBinding(viewGroup: ViewGroup): ItemHouseBinding =
        ItemHouseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

    override fun onViewHolder(itemView: View): ViewHolder = ViewHolder(itemView)

    inner class ViewHolder(itemView: View) : AppRecyclerViewHolder<House>(itemView) {

        override fun bindItem(item: House, position: Int) {
            viewBinding.aivHouseImage.load(item.listImage?.first()) {
                transformations(RoundedCornersTransformation(16F))
            }
            viewBinding.mtvHouseName.text = item.title
            viewBinding.mtvHouseAddress.text = item.address
            viewBinding.mtvHousePrice.text = item.price
        }

    }

}