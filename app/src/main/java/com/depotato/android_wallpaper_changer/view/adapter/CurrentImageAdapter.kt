package com.depotato.android_wallpaper_changer.view.adapter


import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.databinding.LayoutCurrentImageItemBinding
import com.depotato.android_wallpaper_changer.view.adapter.viewholder.CurrentImageViewHolder

class CurrentImageAdapter(): ListAdapter<Bitmap, CurrentImageViewHolder>(
    DiffCallback()
) {

//    override fun getItemCount(): Int {
//        return dataList.size
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentImageViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_current_image_item, parent, false)

        return CurrentImageViewHolder(LayoutCurrentImageItemBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: CurrentImageViewHolder, itemPosition: Int) = holder.bindItems(getItem(itemPosition))

    private class DiffCallback : DiffUtil.ItemCallback<Bitmap>() {

        override fun areItemsTheSame(oldItem: Bitmap, newItem: Bitmap): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Bitmap, newItem: Bitmap): Boolean {
            return oldItem.equals(newItem)
        }
    }

}