package com.depotato.android_wallpaper_changer.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.databinding.LayoutCreateFreeSetButtonBinding
import com.depotato.android_wallpaper_changer.databinding.LayoutFreeSetItemBinding
import com.depotato.android_wallpaper_changer.entity.dataclass.FreeSetItem
import com.depotato.android_wallpaper_changer.view.adapter.viewholder.CreateFreeSetItemEventListener
import com.depotato.android_wallpaper_changer.view.adapter.viewholder.CreateFreeSetViewHolder
import com.depotato.android_wallpaper_changer.view.adapter.viewholder.FreeSetViewHolder

class FreeSetAdapter(private val createFreeSetEvent: CreateFreeSetItemEventListener) : ListAdapter<FreeSetItem, RecyclerView.ViewHolder>(
    DiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        //프리셋 추가하기 버튼
        if(itemCount == viewType + 1){

            LayoutInflater.from(parent.context).inflate(R.layout.layout_create_free_set_button, parent, false).let {
                return CreateFreeSetViewHolder(LayoutCreateFreeSetButtonBinding.bind(it), createFreeSetEvent)
            }

        ////프리셋 Item 목록 출력
        }else{

            LayoutInflater.from(parent.context).inflate(R.layout.layout_free_set_item, parent, false).let {
                return FreeSetViewHolder(LayoutFreeSetItemBinding.bind(it))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, itemPosition: Int){

        if(itemCount == itemPosition + 1){
            //프리셋 추가하기 버튼
            (holder as CreateFreeSetViewHolder).bindItems(getItem(itemPosition))
        }else{
            //프리셋 Item 목록
            (holder as FreeSetViewHolder).bindItems(getItem(itemPosition))
        }

    }

    private class DiffCallback : DiffUtil.ItemCallback<FreeSetItem>() {

        override fun areItemsTheSame(oldItem: FreeSetItem, newItem: FreeSetItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: FreeSetItem, newItem: FreeSetItem): Boolean {
            return oldItem.equals(newItem)
        }
    }


}