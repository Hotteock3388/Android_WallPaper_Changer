package com.depotato.android_wallpaper_changer.di.module

import com.depotato.android_wallpaper_changer.view.apply.ApplyViewModel
import com.depotato.android_wallpaper_changer.view.free_set.CreateFreeSetViewModel
import com.depotato.android_wallpaper_changer.view.free_set.FreeSetViewModel
import com.depotato.android_wallpaper_changer.view.loading.LoadingViewModel
import com.depotato.android_wallpaper_changer.view.main.MainViewModel
import com.depotato.android_wallpaper_changer.view.option.OptionViewModel
import com.depotato.android_wallpaper_changer.view.splash.SplashViewModel
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
        LoadingViewModel(get())
    }

    viewModel {
        FreeSetViewModel()
    }

    viewModel {
        OptionViewModel()
    }

    viewModel {
        CreateFreeSetViewModel()
    }

}