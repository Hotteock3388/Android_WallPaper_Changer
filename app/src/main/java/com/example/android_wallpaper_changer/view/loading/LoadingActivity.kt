package com.example.android_wallpaper_changer.view.loading

import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import com.example.android_wallpaper_changer.R
import com.example.android_wallpaper_changer.base.BaseActivity
import com.example.android_wallpaper_changer.databinding.ActivityLoadingBinding
import com.example.android_wallpaper_changer.model.local.ImageArrManager
import com.example.android_wallpaper_changer.model.local.SharedPref
import com.example.android_wallpaper_changer.view.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.system.measureNanoTime


class LoadingActivity : BaseActivity<ActivityLoadingBinding, LoadingViewModel>(R.layout.activity_loading) {

    override val viewModel: LoadingViewModel by viewModel()

    var create = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.processedImageArrayList.observe(this, {
            BackTask(viewModel).execute()
        })

        viewModel.saveComplete.observe(this, {
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