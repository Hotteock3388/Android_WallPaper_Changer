package com.depotato.android_wallpaper_changer.view.option

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseFragment
import com.depotato.android_wallpaper_changer.databinding.FragmentOptionBinding
import org.koin.android.ext.android.inject

class OptionFragment : BaseFragment<FragmentOptionBinding, OptionViewModel>(R.layout.fragment_option ,"OptionFragment") {

    override val viewModel: OptionViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}