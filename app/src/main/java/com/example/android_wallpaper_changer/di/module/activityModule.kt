package com.example.android_wallpaper_changer.di.module

import com.example.android_wallpaper_changer.view.apply.ApplyViewModel
import com.example.android_wallpaper_changer.view.loading.LoadingViewModel
import com.example.android_wallpaper_changer.view.main.MainViewModel
import com.example.android_wallpaper_changer.view.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val activityModule = module {

    viewModel {
        MainViewModel()
    }
    
    viewModel { 
        SplashViewModel(get())
    }
    
    viewModel { 
        ApplyViewModel()
    }

    viewModel {
        LoadingViewModel()
    }

}