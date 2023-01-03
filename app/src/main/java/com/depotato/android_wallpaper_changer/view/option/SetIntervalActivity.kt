package com.depotato.android_wallpaper_changer.view.option

import android.os.Bundle
import android.view.View
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseActivity
import com.depotato.android_wallpaper_changer.databinding.ActivitySetIntervalBinding
import org.koin.android.ext.android.inject

class SetIntervalActivity : BaseActivity<ActivitySetIntervalBinding ,OptionViewModel> (R.layout.activity_set_interval, "SetIntervalFragment") {

    override val viewModel: OptionViewModel by inject()

    override fun init() {

    }


}