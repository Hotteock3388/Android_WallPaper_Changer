package com.example.android_wallpaper_changer.view.apply

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import com.example.android_wallpaper_changer.base.BaseViewModel
import com.example.android_wallpaper_changer.model.local.ImageArrManager
import com.example.android_wallpaper_changer.model.local.SharedPref
import com.example.android_wallpaper_changer.model.repository.ImageRepository
import com.example.android_wallpaper_changer.view.adapter.MyAdapter

class ApplyViewModel(private val imageRepository: ImageRepository): BaseViewModel() {

    var selectedImageArrayList = ArrayList<Bitmap>()

    var adapter = MyAdapter(selectedImageArrayList)

    lateinit var imageView: ImageView

    val processedImageArr = ArrayList<Bitmap>()

    val fin = MutableLiveData<String>()

    fun apply(){
        processImageArr()
        //repository.saveImageDataToSharedPref(Singleton.processedImageArr)
        finish("적용 완료")
    }

    fun cancel(){
        finish("취소")
    }

    private fun processImageArr(){

        for(i in 0 until selectedImageArrayList.size){

        }
        imageRepository.saveProcessImageToSharedPref(processedImageArr)
        //arr.add(binding.viewPager2ApplyActivity.get(i).imageView_ViewPagerItem.getDrawingCache(false))

    }

    private fun finish(msg: String){
        fin.value = msg
    }

}