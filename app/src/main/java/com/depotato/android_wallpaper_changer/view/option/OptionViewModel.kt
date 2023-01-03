package com.depotato.android_wallpaper_changer.view.option

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.depotato.android_wallpaper_changer.base.BaseViewModel
import kotlinx.coroutines.launch

class OptionViewModel: BaseViewModel("OptionViewModel") {

    private val _onClickSetIntervalButton = MutableLiveData<Unit>()
    val onClickSetIntervalButton : LiveData<Unit>
        get() = _onClickSetIntervalButton

    private val _onClickSetApplyRangeButton = MutableLiveData<Unit>()
    val onClickSetApplyRangeButton : LiveData<Unit>
        get() = _onClickSetApplyRangeButton


    fun openIntervalFragment(){
        _onClickSetIntervalButton.value = Unit
    }

    fun openApplyRangeFragment(){
        _onClickSetApplyRangeButton.value = Unit
    }


}