package com.depotato.android_wallpaper_changer.view.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.depotato.android_wallpaper_changer.R

class MyAdapter(private val dataList: ArrayList<Bitmap>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_viewpager_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, itemPosition: Int) {
        holder.bindItemStatusListItems(dataList[itemPosition])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bindItemStatusListItems(data: Bitmap){
            itemView.findViewById<ImageView>(R.id.imageView_ViewPagerItem).let {
                it.setImageBitmap(data)
            }

        }
    }

}
