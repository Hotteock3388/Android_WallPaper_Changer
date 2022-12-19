package com.depotato.android_wallpaper_changer.view.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.databinding.LayoutCurrentImageItemBinding
import com.depotato.android_wallpaper_changer.databinding.LayoutFreeSetImageItemBinding
import com.depotato.android_wallpaper_changer.view.adapter.viewholder.FreeSetImageViewHolder

class FreeSetImageAdapter(): ListAdapter<Bitmap, FreeSetImageViewHolder>(
    DiffCallback()
) {

//    override fun getItemCount(): Int {
//        return dataList.size
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FreeSetImageViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_free_set_image_item, parent, false)

        return FreeSetImageViewHolder(LayoutFreeSetImageItemBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: FreeSetImageViewHolder, itemPosition: Int) = holder.bindItems(getItem(itemPosition))

    private class DiffCallback : DiffUtil.ItemCallback<Bitmap>() {

        override fun areItemsTheSame(oldItem: Bitmap, newItem: Bitmap): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Bitmap, newItem: Bitmap): Boolean {
            return oldItem.equals(newItem)
        }
    }

}