package com.edw.mvvmlibs.utils

import android.graphics.Typeface
import com.edw.mvvmlibs.base.BaseApp

/**
 * Author: EdwardWMD
 * Data: 2021/3/11
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
object TextUtils {

    /**
     * 设置字体类型
     */
    fun setTextStyle(type: Type): Typeface {
        var typeface: Typeface? = null
        when (type) {
            Type.FZLANTINGHEI_DB -> typeface = Typeface.createFromAsset(
                BaseApp.appContext().assets,
                "fonts/FZLanTingHeiS-DB1-GB-Regular.TTF"
            )

            Type.FZLANTINGHEI_L -> typeface = Typeface.createFromAsset(
                BaseApp.appContext().assets,
                "fonts/FZLanTingHeiS-L-GB-Regular.TTF"
            )

            Type.LOBSTER -> typeface = Typeface.createFromAsset(
                BaseApp.appContext().assets,
                "fonts/Lobster-1.4.otf"
            )
            Type.BRIGHTONS -> typeface = Typeface.createFromAsset(
                BaseApp.appContext().assets,
                "fonts/Brightons-2.otf"
            )
            Type.REFLISATTA -> typeface = Typeface.createFromAsset(
                BaseApp.appContext().assets,
                "fonts/Reflisatta-2.ttf"
            )
        }
        return typeface!!
    }

   fun beforeSubString(originalString:String,delimiter: String,missingDelimiterValue:String):String{
       return originalString.substringBefore(delimiter,missingDelimiterValue)
   }




    enum class Type {
        FZLANTINGHEI_DB, FZLANTINGHEI_L, LOBSTER, BRIGHTONS, REFLISATTA
    }

}