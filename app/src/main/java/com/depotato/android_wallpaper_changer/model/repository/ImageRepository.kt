package com.depotato.android_wallpaper_changer.model.repository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.model.local.ImageArrManager
import com.depotato.android_wallpaper_changer.model.local.SharedPref
import org.koin.core.component.KoinComponent


class ImageRepository(private val context: Context) : KoinComponent {

    private val sharedPref = SharedPref(context)

    //존재한다면 이미지 Arr Return 아니라면 다른 샘플 이미지 Arr Return
    fun getImageData(): ArrayList<Bitmap> {
        return if(checkImageArrExist()){
            getImageDataFromSharedPref()
        }else{
            createDummyData()
        }
    }

    //이전에 저장해둔 사진 Arr이 존재하는지
    private fun checkImageArrExist(): Boolean {
        return sharedPref.isExistImageArr()
    }

    private fun getImageDataFromSharedPref() : ArrayList<Bitmap> {
        return sharedPref.getImageArr()
    }

    fun saveImageDataToSharedPref(arr: ArrayList<Bitmap>) {
        ImageArrManager.imageArr.value = arr
        sharedPref.saveBitmapImageArr(arr)
    }

    fun saveProcessImageToSharedPref(arr: ArrayList<Bitmap>) {
        sharedPref.saveBitmapImageArr(arr)
        ImageArrManager.imageArr.postValue(arr)
    }

    private fun createDummyData(): ArrayList<Bitmap> {
        return arrayListOf(
            decodeRes(R.drawable.afternoon),
            decodeRes(R.drawable.day),
            decodeRes(R.drawable.night)
        )
    }

    private fun decodeRes(resId: Int): Bitmap {
        return BitmapFactory.decodeResource(context.resources, resId)
    }

}

