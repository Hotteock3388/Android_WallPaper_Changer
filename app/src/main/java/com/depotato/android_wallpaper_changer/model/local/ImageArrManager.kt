package com.depotato.android_wallpaper_changer.model.local

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData

object ImageArrManager {

    var imageArr = MutableLiveData<ArrayList<Bitmap>>()

    var selectedImageArr = ArrayList<Bitmap>()

    //var processedImageArr = ArrayList<Bitmap>()

}