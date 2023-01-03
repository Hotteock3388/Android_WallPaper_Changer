package com.depotato.android_wallpaper_changer.view.option

import android.content.Intent
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseFragment
import com.depotato.android_wallpaper_changer.databinding.FragmentOptionBinding
import org.koin.android.ext.android.inject

class OptionFragment : BaseFragment<FragmentOptionBinding, OptionViewModel>(R.layout.fragment_option ,"OptionFragment") {

    override val viewModel: OptionViewModel by inject()


    override fun initLiveData() {

        with(viewModel){
            onClickSetIntervalButton.observe(viewLifecycleOwner){
                startActivity(Intent(requireContext(), SetIntervalActivity::class.java))
            }

            onClickSetApplyRangeButton.observe(viewLifecycleOwner){
                startActivity(Intent(requireContext(), SetApplyRangeActivity::class.java))
            }

        }
    }


}