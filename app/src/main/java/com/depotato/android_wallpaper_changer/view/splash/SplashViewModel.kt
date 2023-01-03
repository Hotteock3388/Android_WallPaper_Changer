package com.depotato.android_wallpaper_changer.view.splash

import com.depotato.android_wallpaper_changer.base.BaseViewModel
import com.depotato.android_wallpaper_changer.data.local.ImageArrManager
import com.depotato.android_wallpaper_changer.data.repository.ImageRepository

class SplashViewModel(private val imageRepo: ImageRepository): BaseViewModel("SplashViewModel") {

    fun initImageData(){
        ImageArrManager.imageArr.value = imageRepo.getImageData()
    }

}