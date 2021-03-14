package com.edw.mvvmlibs.utils

import android.os.Looper

/**
 * Author: EdwardWMD
 * Data: 2021/3/15
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
object ThreadUtils {

    fun isMainThread(): String {
        return if (Thread.currentThread()==Looper.getMainLooper().thread)"是" else "不是"
    }
}