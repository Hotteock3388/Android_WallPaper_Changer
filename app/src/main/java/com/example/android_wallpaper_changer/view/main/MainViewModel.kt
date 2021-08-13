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

    var imageSettingButtonClick = MutableLiveData<Unit>()

    var vpPosition = MutableLiveData<Int>()

    var startServiceCLick = MutableLiveData<Unit>()

    var saveComplete = MutableLiveData<Unit>()

    var galleryIntent = MutableLiveData<Intent>()


    init {
        vpPosition.value = 0
    }

    fun startService(){
        startServiceCLick.value = Unit
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

    fun openGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        galleryIntent.value = intent
        //galleryIntent.value = Intent.createChooser(galleryIntent.value, "배경화면 선택", )

    }

    fun saveSelectedImage(contentResolver: ContentResolver, data: Intent?){
        val bitmapArr = ArrayList<Bitmap>()

        data?.clipData.let {
            for (i in 0 until it?.itemCount!!) {
                bitmapArr.add(MediaStore.Images.Media.getBitmap(contentResolver, it.getItemAt(i).uri))
            }
        }

        ImageArrManager.selectedImageArr = bitmapArr

        saveComplete.value = Unit
    }

}