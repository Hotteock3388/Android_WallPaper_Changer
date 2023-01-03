package com.depotato.android_wallpaper_changer.entity.dataclass

import android.graphics.Bitmap
import androidx.room.Entity

data class FreeSetItem(
    var name : String,
    var imagesArr: ArrayList<Bitmap>?
)

