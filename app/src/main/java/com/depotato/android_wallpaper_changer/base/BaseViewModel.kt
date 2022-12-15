package com.depotato.android_wallpaper_changer.base

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


open class BaseViewModel(
    private val className: String
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)

    fun showLog(msg: String) = Log.d("TestLog_$className", msg)

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}