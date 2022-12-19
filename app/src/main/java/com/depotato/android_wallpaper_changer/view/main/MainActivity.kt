package com.depotato.android_wallpaper_changer.view.main

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseActivity
import com.depotato.android_wallpaper_changer.databinding.ActivityMainBinding
import com.depotato.android_wallpaper_changer.service.ChangeWallPaperService
import com.depotato.android_wallpaper_changer.view.apply.ApplyActivity
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main, "MainActivity") {

    override val viewModel : MainViewModel by inject()

    private var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.imageView.setOnClickListener {
            startWPCService()
        }
        viewModel.vpPosition.observe(this) {
            binding.viewPagerMainActivity.currentItem = it
        }

        viewModel.galleryIntent.observe(this) {
            startActivityForResult(
                Intent.createChooser(viewModel.galleryIntent.value, "배경화면 선택"),
                14423
            )
        }

        viewModel.saveComplete.observe(this) {
            startActivity(Intent(this, ApplyActivity::class.java))
        }

        //ViewPager Adapter 초기화
        viewModel.adapter.also {
            binding.viewPagerMainActivity.adapter = it
        }.notifyDataSetChanged()

    }

    private fun startWPCService(){
        if(!isServiceRunning2()){
            ContextCompat.startForegroundService(
                binding.root.context,
                Intent(binding.root.context, ChangeWallPaperService::class.java)
            )
        }
    }
    private fun isServiceRunning2(): Boolean{
        val manager: ActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service in manager.getRunningServices(Integer.MAX_VALUE)){
            if(service.service.className == ChangeWallPaperService::class.java.name){
                showLog("serviceClassName = ${service.service.className}")
                return true

            }
        }
        return false
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK){
            if (data != null) {
                if(data.clipData != null && data.clipData!!.itemCount != 1){ //사진을 여러 장 골라서 잘 작동 할 경우
                    viewModel.saveSelectedImage(contentResolver ,data)
                }
                else{ // 사진을 한 장만 골랐을 경우
                    showToast("사진을 여러 장 선택해주세요!")
                }
            }
            else{ // 사진을 아예 안 골랐을 경우?
                showToast("취소")
            }
        }
    }

    override fun onBackPressed() {
        //1번 눌렀을 때
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            Toast.makeText(applicationContext, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
        //2초 안에 2번 눌렀을 때 종료
        else if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish()
        }
    }

}