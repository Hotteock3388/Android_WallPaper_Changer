package com.example.android_wallpaper_changer.view.splash

import android.content.Intent
import android.os.Bundle
import com.example.android_wallpaper_changer.R
import com.example.android_wallpaper_changer.base.BaseActivity
import com.example.android_wallpaper_changer.databinding.ActivitySplashBinding
import com.example.android_wallpaper_changer.view.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(R.layout.activity_splash) {

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