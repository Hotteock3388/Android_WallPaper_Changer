package com.depotato.android_wallpaper_changer.view.freeset

import android.graphics.Bitmap
import com.depotato.android_wallpaper_changer.base.BaseViewModel
import com.depotato.android_wallpaper_changer.entity.dataclass.FreeSetItem
import com.depotato.android_wallpaper_changer.model.local.ImageArrManager

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
}