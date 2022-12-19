package com.depotato.android_wallpaper_changer.view.freeset

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseFragment
import com.depotato.android_wallpaper_changer.databinding.FragmentFreeSetBinding
import com.depotato.android_wallpaper_changer.model.local.ImageArrManager
import com.depotato.android_wallpaper_changer.view.adapter.CurrentImageAdapter
import com.depotato.android_wallpaper_changer.view.adapter.FreeSetAdapter
import org.koin.android.ext.android.inject


class FreeSetFragment : BaseFragment<FragmentFreeSetBinding, FreeSetViewModel>(
    R.layout.fragment_free_set,
    "FreeSetFragment"
) {

    override val viewModel: FreeSetViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun init() {
        binding.recyclerViewFreeSet.apply {
            adapter = FreeSetAdapter()
            (adapter as FreeSetAdapter).submitList(
                viewModel.dummyDataList
            )
        }

    }
}
