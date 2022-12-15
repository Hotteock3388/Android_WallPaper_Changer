package com.depotato.android_wallpaper_changer.service

import android.app.*
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.model.local.SharedPref
import com.depotato.android_wallpaper_changer.view.main.MainActivity
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
//                    WallpaperManager.getInstance(applicationContext).setM
                    WallpaperManager.getInstance(applicationContext).setBitmap(sharedPref.getImage(i++))

                    //val wall = WallpaperManager.getInstance(applicationContext)
                    //wall.setBitmap(sharedPref.getImage(i++), null, false, WallpaperManager.FLAG_SYSTEM) // 홈 화면
                    //wall.setBitmap(sharedPref.getImage(i++), null, false, WallpaperManager.FLAG_LOCK) // 잠금 화면

                    //10분마다 배경화면 변경
                    sleep(1000 * 60 * 10)

                }else {
                    i = 0
                }
            }
        }).start()

    }

    private fun startForegroundService(){
        Log.d("TestLog", "startForegroundService")
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .apply {
                setSmallIcon(R.mipmap.ic_launcher)
                setContentTitle("배경화면 로테이션")
                setContentText("배경화면 로테이션 실행중")
            }

        //PendingIntent를 사용해서 Notification을 누르면 MainActivity가 켜지게 함
        val notiIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notiIntent, FLAG_IMMUTABLE)
        builder.setContentIntent(pendingIntent)

        //Notification Channel이 Oreo(SDK V.26)이후부터 생김
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(NotificationChannel(CHANNEL_ID, "기본 채널", NotificationManager.IMPORTANCE_DEFAULT))
        }

            Log.d("TestLog", "StartForeground")
            startForeground(FOREGROUND_ID, builder.build())

    }

    //서비스가 이미 실행중인지 확인
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
