package com.depotato.android_wallpaper_changer.di.app

import android.app.Application
import com.depotato.android_wallpaper_changer.di.module.activityModule
import com.depotato.android_wallpaper_changer.di.module.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                activityModule,
                repositoryModule
            )
        }
    }

}