package com.example.android_wallpaper_changer.view.apply

import androidx.lifecycle.MutableLiveData
import com.example.android_wallpaper_changer.base.BaseViewModel
import com.example.android_wallpaper_changer.model.local.ImageArrManager
import com.example.android_wallpaper_changer.view.adapter.MyAdapter

class ApplyViewModel: BaseViewModel() {

    var adapter = MyAdapter(ImageArrManager.selectedImageArr)

    val fin = MutableLiveData<String>()

    fun apply(){
        //repository.saveImageDataToSharedPref(Singleton.processedImageArr)
        finish("적용 완료")
    }

    fun cancel(){
        finish("취소")
    }

    private fun finish(msg: String){
        fin.value = msg
    }

}