package com.example.android_wallpaper_changer.view.apply

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import com.example.android_wallpaper_changer.R
import com.example.android_wallpaper_changer.base.BaseActivity
import com.example.android_wallpaper_changer.databinding.ActivityApplyBinding
import com.example.android_wallpaper_changer.model.local.ImageArrManager
import com.example.android_wallpaper_changer.model.local.SharedPref
import com.example.android_wallpaper_changer.view.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApplyActivity : BaseActivity<ActivityApplyBinding, ApplyViewModel>(R.layout.activity_apply) {

    override val viewModel: ApplyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //RecyclerView Adapter 초기화
        viewModel.adapter.also {
            binding.viewPager2ApplyActivity.adapter = it
        }.notifyDataSetChanged()

        //적용 완료 or 취소
        viewModel.fin.observe(this, {

            val arr = ArrayList<Bitmap>()
            showLog("${ImageArrManager.selectedImageArr.size}")
            ImageArrManager.processedImageArr.clear()

            for(i in 0 until ImageArrManager.selectedImageArr.size){
                with(binding.imageViewProcessApplyActivity){
                    setImageBitmap(ImageArrManager.selectedImageArr[i])
                    buildDrawingCache()
                    isDrawingCacheEnabled = true
                    ImageArrManager.processedImageArr.add(Bitmap.createBitmap(drawingCache))
                }
            }

            SharedPref(baseContext).saveBitmapImageArr(ImageArrManager.processedImageArr)
            //arr.add(binding.viewPager2ApplyActivity.get(i).imageView_ViewPagerItem.getDrawingCache(false))
            ImageArrManager.imageArr.value = ImageArrManager.processedImageArr
            gotoMainActivity(it)
        })


    }

    private fun gotoMainActivity(msg: String){
        showToast(msg)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}