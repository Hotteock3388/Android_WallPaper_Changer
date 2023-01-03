package com.depotato.android_wallpaper_changer.base

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.depotato.android_wallpaper_changer.BR

abstract class BaseActivity<B: ViewDataBinding, VM: BaseViewModel>(
    @LayoutRes private val layoutResId: Int,
    private val className: String
): AppCompatActivity() {

    lateinit var binding: B

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<B>(this, layoutResId)
        binding.setVariable(BR.vm, viewModel)
        binding.lifecycleOwner = this

        init()
        initLiveData()
        initListener()
    }


    open fun init() {}

    open fun initLiveData() {}

    open fun initListener() {}

    fun showToast(message: String) = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    fun showLog(msg: String) = Log.d("TestLog_$className", msg)

}