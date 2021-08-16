package com.example.android_wallpaper_changer.service

import android.app.Service
import android.app.WallpaperManager
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.android_wallpaper_changer.model.local.SharedPref

class CustomService: Service() {

    private val sharedPref = SharedPref(applicationContext)

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        Log.d("TestLog", "onStartCommand")

        rotateWallPaper()

        return START_STICKY
    }

    private fun rotateWallPaper(){
        Log.d("TestLog", "rotateWallPaper")
        var i = 0
        val thread = Thread(Runnable{
            while (true){
                if(sharedPref.isExist(sharedPref.getKey(i))){
                    //wallpaperManager.setBitmap(sharedPref.getImageArr(applicationContext)[++i %6])
                    WallpaperManager.getInstance(applicationContext).setBitmap(sharedPref.getImage(i++))

                    //val wall = WallpaperManager.getInstance(applicationContext)
                    //wall.setBitmap(sharedPref.getImage(i++), null, false, WallpaperManager.FLAG_SYSTEM)
                    //wall.setBitmap(sharedPref.getImage(i++), null, false, WallpaperManager.FLAG_LOCK)
                    Log.d("TestLog", "rotate!")

                    //10분마다 배경화면 변경
                    //Test 중 10초마다 변경
                    Thread.sleep(10000)

                }else {
                    i = 0
                }
            }
        })
        thread.start()

    }

}