package com.depotato.android_wallpaper_changer.view.adapter.viewholder

import android.graphics.Bitmap
import androidx.recyclerview.widget.RecyclerView
import com.depotato.android_wallpaper_changer.databinding.LayoutCurrentImageItemBinding
import com.depotato.android_wallpaper_changer.databinding.LayoutFreeSetItemBinding
import com.depotato.android_wallpaper_changer.entity.dataclass.FreeSetItem
import com.depotato.android_wallpaper_changer.model.local.ImageArrManager
import com.depotato.android_wallpaper_changer.view.adapter.CurrentImageAdapter
import com.depotato.android_wallpaper_changer.view.adapter.FreeSetImageAdapter

class FreeSetViewHolder(
    private val binding: LayoutFreeSetItemBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bindItems(data: FreeSetItem) {

        binding.textViewFreeSetName.text = data.name

        binding.recyclerViewFreeSetImages.apply {
            adapter = FreeSetImageAdapter()
            (adapter as FreeSetImageAdapter).submitList(
                data.imagesArr
            )
        }
    }
}