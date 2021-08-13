package com.example.android_wallpaper_changer.view.splash

import com.example.android_wallpaper_changer.base.BaseViewModel
import com.example.android_wallpaper_changer.model.local.ImageArrManager
import com.example.android_wallpaper_changer.model.repository.ImageRepository

class SplashViewModel(private val imageRepo: ImageRepository): BaseViewModel() {

    fun initImageData(){
        ImageArrManager.imageArr.value = imageRepo.getImageData()
    }

}