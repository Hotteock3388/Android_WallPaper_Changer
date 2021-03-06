package com.example.android_wallpaper_changer.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.android_wallpaper_changer.R
import com.example.android_wallpaper_changer.model.local.ImageArrManager
import com.example.android_wallpaper_changer.model.local.SharedPref
import com.example.android_wallpaper_changer.view.main.MainActivity
import java.lang.Thread.sleep

class ChangeWallPaperService : Service() {

    private lateinit var mReceiver: CustomReceiver
    private val CHANNEL_ID = "Android_WallPaper_Changer"
    private val FOREGROUND_ID = 1248295

    private lateinit var sharedPref: SharedPref

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        sharedPref = SharedPref(applicationContext)
        startForegroundService()
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

        Thread(Runnable{
            while (true){
                if(sharedPref.isExist(sharedPref.getKey(i))){
                    //wallpaperManager.setBitmap(sharedPref.getImageArr(applicationContext)[++i %6])
                    WallpaperManager.getInstance(applicationContext).setBitmap(sharedPref.getImage(i++))

                    //val wall = WallpaperManager.getInstance(applicationContext)
                    //wall.setBitmap(sharedPref.getImage(i++), null, false, WallpaperManager.FLAG_SYSTEM)
                    //wall.setBitmap(sharedPref.getImage(i++), null, false, WallpaperManager.FLAG_LOCK)
                    Log.d("TestLog", "rotate!")

                    //10????????? ???????????? ??????
                    //Test ??? 10????????? ??????
                    sleep(10000)

                }else {
                    i = 0
                }
            }
        }).start()

    }

    private fun startForegroundService(){
        Log.d("TestLog", "startForegroundService")
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
        builder.setSmallIcon(R.mipmap.ic_launcher)
        builder.setContentTitle("Android_WallPaper_Changer")
        builder.setContentText("Foreground ????????? ?????????")

        //PendingIntent??? ???????????? Notification??? ????????? MainActivity??? ????????? ???
        val notiIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notiIntent, 0)
        builder.setContentIntent(pendingIntent)

        //Notification Channel??? Oreo(SDK V.26)???????????? ??????
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(NotificationChannel(CHANNEL_ID, "?????? ??????", NotificationManager.IMPORTANCE_DEFAULT))
        }

            Log.d("TestLog", "StartForeground")
            startForeground(FOREGROUND_ID, builder.build())

    }

    //???????????? ?????? ??????????????? ??????
    private fun Context.isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                Log.d("isServiceRunning", "Service is running")
                return true
            }
        }
        return false
    }

}
