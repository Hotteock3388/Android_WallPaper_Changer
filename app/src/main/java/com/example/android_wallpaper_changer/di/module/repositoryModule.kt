package com.example.android_wallpaper_changer.di.module

import com.example.android_wallpaper_changer.model.local.SharedPref
import com.example.android_wallpaper_changer.model.repository.ImageRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module



val repositoryModule = module {

    single {
        SharedPref(androidContext())
    }

    factory {
        ImageRepository(get())
    }
}