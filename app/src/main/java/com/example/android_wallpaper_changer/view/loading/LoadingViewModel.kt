package com.example.android_wallpaper_changer.view.loading

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import com.example.android_wallpaper_changer.base.BaseViewModel
import com.example.android_wallpaper_changer.model.repository.ImageRepository
import kotlin.concurrent.thread

class LoadingViewModel(private val imageRepository: ImageRepository): BaseViewModel() {

    var processedImageArrayList = MutableLiveData<ArrayList<Bitmap>>()

    val saveComplete =  MutableLiveData<Unit>()

    fun saveProcessedImageArrayList(){
        imageRepository.saveProcessImageToSharedPref(processedImageArrayList.value!!)
        saveComplete.postValue(Unit)
    }

}