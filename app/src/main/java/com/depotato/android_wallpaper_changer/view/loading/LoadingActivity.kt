package com.depotato.android_wallpaper_changer.view.loading

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.databinding.ActivityLoadingBinding
import com.depotato.android_wallpaper_changer.model.local.ImageArrManager
import com.depotato.android_wallpaper_changer.service.ChangeWallPaperService
import com.depotato.android_wallpaper_changer.view.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.ext.getScopeName
import kotlin.system.measureNanoTime


class LoadingActivity : com.depotato.android_wallpaper_changer.base.BaseActivity<ActivityLoadingBinding, LoadingViewModel>(R.layout.activity_loading) {

    override val viewModel: LoadingViewModel by viewModel()

    var create = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.processedImageArrayList.observe(this, {
            BackTask(viewModel).execute()
        })

        viewModel.saveComplete.observe(this, {
            if(!isServiceRunning2()){
                ContextCompat.startForegroundService(
                    binding.root.context,
                    Intent(binding.root.context, ChangeWallPaperService::class.java)
                )
            }
            startActivity(Intent(this, MainActivity::class.java))
            showToast("적용 완료!")
            finish()
        })

        binding.lottieAnimationView.playAnimation()

        binding.lottieAnimationView.addAnimatorUpdateListener {
            if(!create){
                processImageArr()
                create = true
            }

        }
    }
    private fun isServiceRunning2(): Boolean{
        val manager: ActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        val serviceClass = ChangeWallPaperService()
        showLog("WPS_ScopmeName = ${serviceClass.getScopeName()}")

        for (service in manager.getRunningServices(Integer.MAX_VALUE)){
            if(service.service.className == "ChangeWallPaperService"){
                showLog("serviceClassName = ${service.service.className}")
                return true

            }
        }
        return false
    }

    fun Context.isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                Log.d("isServiceRunning", "Service is running")
                return true
            }
        }
        return false
    }


    private fun processImageArr(){

        val processedImageArr = ArrayList<Bitmap>()

        showLog("forEach : ${measureNanoTime {
            ImageArrManager.selectedImageArr.forEach {
                with(binding.imageViewProcessLoadingActivity){
                    setImageBitmap(it)
                    buildDrawingCache()
                    isDrawingCacheEnabled = true
                    processedImageArr.add(Bitmap.createBitmap(drawingCache))
                }
            }
            viewModel.processedImageArrayList.postValue(processedImageArr)
        }}")

    }


    override fun onDestroy() {
        super.onDestroy()
        ImageArrManager.selectedImageArr.clear()
    }
}

class BackTask(private val viewModel:LoadingViewModel) : AsyncTask<Int, Int, Int>() {

    override fun doInBackground(vararg params: Int?): Int {

        viewModel.saveProcessedImageArrayList()

        return 0
    }



}