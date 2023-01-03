package com.depotato.android_wallpaper_changer.view.free_set

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.depotato.android_wallpaper_changer.R
import com.depotato.android_wallpaper_changer.base.BaseFragment
import com.depotato.android_wallpaper_changer.databinding.FragmentFreeSetBinding
import com.depotato.android_wallpaper_changer.view.adapter.FreeSetAdapter
import com.depotato.android_wallpaper_changer.view.adapter.viewholder.CreateFreeSetItemEventListener
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

        //프리셋 추가하기 버튼용 Blank Item 추가
        viewModel.addCreateFreeSetButton()

        //프리셋 RecyclerView 어뎁터 설정
        binding.recyclerViewFreeSet.apply {
            adapter = FreeSetAdapter(createFreeSetEvent)
            (adapter as FreeSetAdapter).submitList(
                viewModel.dummyDataList
            )

        }

    }

    private val createFreeSetEvent = object : CreateFreeSetItemEventListener() {
        override fun onClickCreateFreeSet() {

            startActivity(Intent(requireContext(), CreateFreeSetActivity::class.java))
        }
    }

}
