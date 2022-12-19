package com.depotato.android_wallpaper_changer.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseActivity
import com.depotato.android_wallpaper_changer.databinding.ActivityMactivityBinding
import com.depotato.android_wallpaper_changer.view.freeset.FreeSetFragment
import com.depotato.android_wallpaper_changer.view.option.OptionFragment
import org.koin.android.ext.android.inject

class MActivity : BaseActivity<ActivityMactivityBinding, MainViewModel>(R.layout.activity_mactivity, "MActivity") {

    override val viewModel: MainViewModel by inject()

    var lastPath = ""
    var transactionedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun init() {
        initBottomNavigationView()
    }

    private fun setFragment(fragment: Fragment, pageId: Int){
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit()
        binding.bottomNavigationView.selectedItemId = pageId
    }

    private fun initBottomNavigationView(){
        binding.bottomNavigationView.selectedItemId = R.id.page_home

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.page_free_set -> {
                    if(lastPath != "free_set"){
                        replaceFragment(FreeSetFragment(), "free_set", "left")
                    }else false
                }

                R.id.page_home -> {
                    when (binding.bottomNavigationView.selectedItemId) {
                        R.id.page_free_set -> {
                            replaceFragment(MainFragment(),"home", "right")
                        }
                        R.id.page_option -> {
                            replaceFragment(MainFragment(),"home", "left")
                        }
                        else -> { return@setOnItemSelectedListener false }
                    }
                }

                R.id.page_option -> {
                    if(lastPath != "Option")
                        replaceFragment(OptionFragment(),"option", "right")
                    else false
                }

                else -> {
                    return@setOnItemSelectedListener false
                }

            }
        }
    }

    private fun replaceFragment(fragment: Fragment, fragmentName: String, direction: String): Boolean {
        if (System.currentTimeMillis() > transactionedTime + 50) {
            transactionedTime = System.currentTimeMillis()
            val fragmentTransaction = supportFragmentManager.beginTransaction()

//            when(direction){
//                "Left" -> fragmentTransaction.setCustomAnimations(R.anim.from_left, R.anim.to_right)
//                "Right" -> fragmentTransaction.setCustomAnimations(R.anim.from_right, R.anim.to_left)
//            }
            lastPath = fragmentName

            fragmentTransaction.replace(R.id.fragmentContainer, fragment).commit()
            return true
        }
        else{
            return false
        }
    }

    override fun initLiveData() {
         viewModel.saveComplete.observe(this){
             //이벤트 처리
         }
    }

}