package com.depotato.android_wallpaper_changer.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseFragment
import com.depotato.android_wallpaper_changer.databinding.FragmentMainBinding
import com.depotato.android_wallpaper_changer.model.local.ImageArrManager
import com.depotato.android_wallpaper_changer.view.adapter.CurrentImageAdapter
import org.koin.android.ext.android.inject


class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main, "MainFragment") {

    override val viewModel : MainViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun init() {
        binding.recyclerView.apply {
            adapter = CurrentImageAdapter()
            (adapter as CurrentImageAdapter).submitList(
                ImageArrManager.imageArr.value
            )
//            scheduleLayoutAnimation()
        }
    }

}