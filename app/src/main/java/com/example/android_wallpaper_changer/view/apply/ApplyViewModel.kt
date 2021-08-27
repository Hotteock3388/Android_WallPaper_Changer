package com.example.android_wallpaper_changer.view.apply

import androidx.lifecycle.MutableLiveData
import com.example.android_wallpaper_changer.base.BaseViewModel
import com.example.android_wallpaper_changer.model.local.ImageArrManager
import com.example.android_wallpaper_changer.view.adapter.ViewPagerAdapter

class ApplyViewModel(): BaseViewModel() {

    var adapter = ViewPagerAdapter(ImageArrManager.selectedImageArr)

    val apply = MutableLiveData<Unit>()

    val cancel = MutableLiveData<Unit>()


    fun apply(){
        apply.postValue(Unit)
        //repository.saveImageDataToSharedPref(Singleton.processedImageArr)
    }

    fun cancel(){
        cancel.postValue(Unit)
    }

}