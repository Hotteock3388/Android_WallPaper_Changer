package com.depotato.android_wallpaper_changer.view.adapter.viewholder

import android.graphics.Bitmap
import androidx.recyclerview.widget.RecyclerView
import com.depotato.android_wallpaper_changer.databinding.LayoutFreeSetImageItemBinding

class FreeSetImageViewHolder(
private val binding: LayoutFreeSetImageItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItems(data: Bitmap?) {
        binding.imageViewCurrentImageItem.setImageBitmap(data)
    }
}