package com.depotato.android_wallpaper_changer.di.module

import com.depotato.android_wallpaper_changer.data.local.SharedPref
import com.depotato.android_wallpaper_changer.data.repository.ImageRepository
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