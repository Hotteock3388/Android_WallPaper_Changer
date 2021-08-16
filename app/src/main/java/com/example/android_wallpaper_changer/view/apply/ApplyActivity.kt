package com.example.android_wallpaper_changer.view.apply

import android.content.Intent
import android.os.Bundle
import com.example.android_wallpaper_changer.R
import com.example.android_wallpaper_changer.base.BaseActivity
import com.example.android_wallpaper_changer.databinding.ActivityApplyBinding
import com.example.android_wallpaper_changer.model.local.ImageArrManager
import com.example.android_wallpaper_changer.view.loading.LoadingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApplyActivity : BaseActivity<ActivityApplyBinding, ApplyViewModel>(R.layout.activity_apply) {

    override val viewModel: ApplyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //RecyclerView Adapter 초기화
        viewModel.adapter.also {
            binding.viewPager2ApplyActivity.adapter = it
        }.notifyDataSetChanged()

        viewModel.apply.observe(this, {
            startActivity(Intent(this, LoadingActivity::class.java))
        })

        viewModel.cancel.observe(this, {
            ImageArrManager.selectedImageArr.clear()
            finish()
        })
        
    }

}