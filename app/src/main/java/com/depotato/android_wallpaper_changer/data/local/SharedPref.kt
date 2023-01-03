package com.depotato.android_wallpaper_changer.data.local

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import com.depotato.android_wallpaper_changer.util.MyUtil

class SharedPref(val context: Context) {

    private val myUtil = MyUtil()

    fun saveBitmapImageArr(arr: ArrayList<Bitmap>){
        var idx = 0
        getPref(context).edit().run {
            for(i in 0 until arr.size){
                putString(getKey(i), myUtil.bitmapToString(arr[i]))
            }
            removePrevImage(arr.size)

            apply()
        }
    }

    //
    private fun removePrevImage(i: Int){
        if(isExist(getKey(i))){
            getPref(context).edit().run {
                remove(getKey(i))
                apply()
            }
            removePrevImage(i + 1)
        }
    }

    //계속 "ImageBitmap$i" 중복되는게 너무 꼴뵈기 싫어서 만든 메서드
    fun getKey(idx: Int): String {
        return "ImageBitmap$idx"
    }


    fun getImageArr(): ArrayList<Bitmap>{
        var arr = ArrayList<Bitmap>()
        var i = 0
        while (isExist(getKey(i))){
            arr.add(myUtil.stringToBitmap(getPref(context).getString(getKey(i), ""))!!)
            i++
        }
        return arr
    }

    fun getImage(idx: Int): Bitmap? {
        return myUtil.stringToBitmap(getPref(context).getString(getKey(idx), ""))
    }

    fun isExist(key: String): Boolean = getPref(context).contains(key)

    fun isExistImageArr(): Boolean = getPref(context).contains(getKey(0))

    private fun getPref(context: Context): SharedPreferences =
            context.getSharedPreferences("pref", Context.MODE_PRIVATE)

}
