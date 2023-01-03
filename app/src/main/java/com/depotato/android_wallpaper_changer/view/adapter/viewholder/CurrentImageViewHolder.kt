package com.depotato.android_wallpaper_changer.view.adapter.viewholder

import android.graphics.Bitmap
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.depotato.android_wallpaper_changer.databinding.LayoutCurrentImageItemBinding


class CurrentImageViewHolder(
    private val binding: LayoutCurrentImageItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItems(data: Bitmap?) {
        binding.imageViewCurrentImageItem.setImageBitmap(data)
    }
}