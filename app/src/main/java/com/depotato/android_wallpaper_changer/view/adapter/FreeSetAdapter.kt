package com.depotato.android_wallpaper_changer.view.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.databinding.LayoutFreeSetItemBinding
import com.depotato.android_wallpaper_changer.entity.dataclass.FreeSetItem
import com.depotato.android_wallpaper_changer.view.adapter.viewholder.FreeSetViewHolder

class FreeSetAdapter(): ListAdapter<FreeSetItem, FreeSetViewHolder>(
    DiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FreeSetViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_free_set_item, parent, false)

        return FreeSetViewHolder(LayoutFreeSetItemBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: FreeSetViewHolder, itemPosition: Int) = holder.bindItems(getItem(itemPosition))

    private class DiffCallback : DiffUtil.ItemCallback<FreeSetItem>() {

        override fun areItemsTheSame(oldItem: FreeSetItem, newItem: FreeSetItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: FreeSetItem, newItem: FreeSetItem): Boolean {
            return oldItem.equals(newItem)
        }
    }

}