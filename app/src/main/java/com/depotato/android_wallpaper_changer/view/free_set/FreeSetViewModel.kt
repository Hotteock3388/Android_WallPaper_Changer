package com.depotato.android_wallpaper_changer.view.free_set

import com.depotato.android_wallpaper_changer.base.BaseViewModel
import com.depotato.android_wallpaper_changer.entity.dataclass.FreeSetItem
import com.depotato.android_wallpaper_changer.data.local.ImageArrManager

class FreeSetViewModel : BaseViewModel("FreeSetViewModel") {

    val dummyDataList = arrayListOf(
        FreeSetItem(
            name = "더미 프리셋 1",
            imagesArr = ImageArrManager.imageArr.value
        ),
        FreeSetItem(
            name = "더미 프리셋 2",
            imagesArr = ImageArrManager.imageArr.value
        ),
        FreeSetItem(
            name = "더미 프리셋 3",
            imagesArr = ImageArrManager.imageArr.value
        )
    )

    //프리셋 추가하기 버튼용 Blank Item 추가
    fun addCreateFreeSetButton(){
        dummyDataList.add(
            FreeSetItem(
                name = "ADD_FREE_SET_BUTTON",
                null
            )
        )
    }
}