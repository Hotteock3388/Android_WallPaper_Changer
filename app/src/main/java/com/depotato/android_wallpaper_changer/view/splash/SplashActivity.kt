package com.depotato.android_wallpaper_changer.view.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseActivity
import com.depotato.android_wallpaper_changer.databinding.ActivitySplashBinding
import com.depotato.android_wallpaper_changer.view.main.MActivity
import com.depotato.android_wallpaper_changer.view.main.MainActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(R.layout.activity_splash, "SplashActivity") {

    override val viewModel: SplashViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.initImageData()

        startApplication()
    }


    private fun startApplication(){
        finish()
        startActivity(Intent(this, MActivity::class.java))
    }
}