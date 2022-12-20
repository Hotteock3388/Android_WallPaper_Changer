package com.depotato.android_wallpaper_changer.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.depotato.android_wallpaper_changer.BR

abstract class BaseFragment<B : ViewDataBinding, VM: BaseViewModel>(
    @LayoutRes private val layoutResId: Int,
    private val className: String
) : Fragment() {

    fun getStringRes(resId: Int): String {
        return resources.getString(resId)
    }

    lateinit var binding: B

    abstract val viewModel: VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
//            setVariable(BR.fr, this@BaseFragment)
            setVariable(BR.vm, viewModel)
            lifecycleOwner = viewLifecycleOwner
        }

        init()
        initLiveData()
        initListener()
    }

    open fun init() {}

    open fun initLiveData() {}

    open fun initListener() {}

    fun showToast(msg: String) = Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    fun showLog(msg: String) = Log.d("TestLog_$className", msg)

}