package com.example.android_wallpaper_changer.view.main

import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.lifecycle.MutableLiveData
import com.example.android_wallpaper_changer.base.BaseViewModel
import com.example.android_wallpaper_changer.model.local.ImageArrManager
import com.example.android_wallpaper_changer.view.adapter.MyAdapter

class MainViewModel: BaseViewModel() {

    var adapter = MyAdapter(ImageArrManager.imageArr.value!!)

    var vpPosition = MutableLiveData<Int>()

    var saveComplete = MutableLiveData<Unit>()

    var galleryIntent = MutableLiveData<Intent>()

    init {
        vpPosition.value = 0
    }

    fun selectImagesFromMyGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        galleryIntent.value = intent
    }

    fun vpPrevPage(){
        if(vpPosition.value != 0){
            vpPosition.postValue(vpPosition.value!! - 1)
        }
    }

    fun vpNextPage(){
        if(vpPosition.value != ImageArrManager.imageArr.value?.size){
            vpPosition.postValue(vpPosition.value!! + 1)
        }
    }

    fun saveSelectedImage(contentResolver: ContentResolver, data: Intent?){
        val bitmapArr = ArrayList<Bitmap>()

        data?.clipData.let {
            for (i in 0 until it?.itemCount!!) {
                bitmapArr.add(MediaStore.Images.Media.getBitmap(contentResolver, it.getItemAt(i).uri))
            }
        }

        //ImageArrManager.selectedImageArr = bitmapArr

        //applyIntent.putExtra("SelectedImageArr", bitmapArr)
        ImageArrManager.selectedImageArr = bitmapArr

        saveComplete.value = Unit
    }

}