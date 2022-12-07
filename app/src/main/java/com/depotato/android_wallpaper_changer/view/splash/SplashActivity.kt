package com.depotato.android_wallpaper_changer.view.splash

import android.content.Intent
import android.os.Bundle
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseActivity
import com.depotato.android_wallpaper_changer.databinding.ActivitySplashBinding
import com.depotato.android_wallpaper_changer.view.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : com.depotato.android_wallpaper_changer.base.BaseActivity<ActivitySplashBinding, SplashViewModel>(R.layout.activity_splash) {

    override val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.initImageData()

        startApplication()
    }


    private fun startApplication(){
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }
}