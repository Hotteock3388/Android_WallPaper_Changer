package com.depotato.android_wallpaper_changer.view.apply

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseActivity
import com.depotato.android_wallpaper_changer.databinding.ActivityApplyBinding
import com.depotato.android_wallpaper_changer.model.local.ImageArrManager
import com.depotato.android_wallpaper_changer.view.loading.LoadingActivity
import org.koin.android.ext.android.inject

class ApplyActivity : BaseActivity<ActivityApplyBinding, ApplyViewModel>(R.layout.activity_apply, "ApplyActivity") {

    override val viewModel: ApplyViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //RecyclerView Adapter 초기화
        viewModel.adapter.also {
            binding.viewPager2ApplyActivity.adapter = it
        }.notifyDataSetChanged()

        viewModel.apply.observe(this) {
            startActivity(Intent(this, LoadingActivity::class.java))
        }

        viewModel.cancel.observe(this) {
            ImageArrManager.selectedImageArr.clear()
            finish()
        }

    }

}