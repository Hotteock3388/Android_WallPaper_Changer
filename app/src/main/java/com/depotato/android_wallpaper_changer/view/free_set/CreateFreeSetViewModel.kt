package com.depotato.android_wallpaper_changer.view.free_set

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.depotato.android_wallpaper_changer.base.BaseViewModel
import com.depotato.android_wallpaper_changer.entity.dataclass.FreeSetOption

class CreateFreeSetViewModel: BaseViewModel("CreateFreeSetViewModel") {

    // color | size | location | option | angle
    private val _currentMenu = MutableLiveData<String>("color")
    val currentMenu : LiveData<String>
        get() = _currentMenu


    private val _currentOptionData = MutableLiveData<FreeSetOption>()
    val currentOptionData : LiveData<FreeSetOption>
        get() = _currentOptionData



    // color | size | location | option | angle
    fun changeCurrentMenu(menu: String){
        _currentMenu.value = menu
    }

}