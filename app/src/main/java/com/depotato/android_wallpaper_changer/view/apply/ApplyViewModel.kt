package com.depotato.android_wallpaper_changer.view.apply

import androidx.lifecycle.MutableLiveData
import com.depotato.android_wallpaper_changer.base.BaseViewModel
import com.depotato.android_wallpaper_changer.data.local.ImageArrManager
import com.depotato.android_wallpaper_changer.view.adapter.MyAdapter

class ApplyViewModel: BaseViewModel("ApplyViewModel") {

    var adapter = MyAdapter(ImageArrManager.selectedImageArr)

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