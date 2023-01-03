package com.depotato.android_wallpaper_changer.view.free_set

import android.os.Bundle
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseActivity
import com.depotato.android_wallpaper_changer.databinding.ActivityCreateFreeSetBinding
import org.koin.android.ext.android.inject

class CreateFreeSetActivity() : BaseActivity<ActivityCreateFreeSetBinding, CreateFreeSetViewModel>(R.layout.activity_create_free_set, "CreateFreeSetActivity") {


    override val viewModel: CreateFreeSetViewModel by inject()


    override fun init() {

        with(binding){

            currentMenu = viewModel.currentMenu
            freeSetOptionData = viewModel.currentOptionData

            textViewBackgroundColor.setOnClickListener {
                viewModel.changeCurrentMenu("color")
            }

            textViewImageSize.setOnClickListener {
                viewModel.changeCurrentMenu("size")
            }

            textViewImageLocation.setOnClickListener {
                viewModel.changeCurrentMenu("location")
            }

            textViewImageSizingOption.setOnClickListener {
                viewModel.changeCurrentMenu("option")
            }

            textViewImageAngle.setOnClickListener {
                viewModel.changeCurrentMenu("angle")
            }


        }
    }
}