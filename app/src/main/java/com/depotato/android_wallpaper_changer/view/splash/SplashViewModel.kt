package com.depotato.android_wallpaper_changer.view.splash

import com.depotato.android_wallpaper_changer.base.BaseViewModel
import com.depotato.android_wallpaper_changer.model.local.ImageArrManager
import com.depotato.android_wallpaper_changer.model.repository.ImageRepository

class SplashViewModel(private val imageRepo: ImageRepository): com.depotato.android_wallpaper_changer.base.BaseViewModel() {

    fun initImageData(){
        ImageArrManager.imageArr.value = imageRepo.getImageData()
    }

}