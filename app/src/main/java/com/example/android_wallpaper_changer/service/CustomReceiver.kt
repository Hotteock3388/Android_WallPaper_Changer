package com.example.android_wallpaper_changer.service


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startForegroundService

class CustomReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("TestLog", "${intent.action}")

        if (intent.action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            Log.d("TestLog", "boot complete received")
            startService(context)
        }
    }

    private fun startService(context: Context){
        Log.d("TestLog", "startService")
        startForegroundService(context, Intent(context, ChangeWallPaperService::class.java))
    }

}
