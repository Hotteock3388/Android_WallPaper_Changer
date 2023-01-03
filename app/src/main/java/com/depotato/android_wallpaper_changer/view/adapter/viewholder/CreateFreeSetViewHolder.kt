package com.depotato.android_wallpaper_changer.view.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.depotato.android_wallpaper_changer.databinding.LayoutCreateFreeSetButtonBinding
import com.depotato.android_wallpaper_changer.databinding.LayoutFreeSetItemBinding
import com.depotato.android_wallpaper_changer.entity.dataclass.FreeSetItem
import com.depotato.android_wallpaper_changer.view.adapter.FreeSetAdapter
import com.depotato.android_wallpaper_changer.view.adapter.FreeSetImageAdapter

class CreateFreeSetViewHolder(
    private val binding: LayoutCreateFreeSetButtonBinding,
    private val createFreeSetEvent: CreateFreeSetItemEventListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItems(freeSetItem: FreeSetItem) {

        binding.event = createFreeSetEvent

    }

    interface RecyclerViewItemEvent {
        fun onClickCreateFreeSet()
    }

}

open class CreateFreeSetItemEventListener
    : CreateFreeSetViewHolder.RecyclerViewItemEvent {

    override fun onClickCreateFreeSet() {}

}