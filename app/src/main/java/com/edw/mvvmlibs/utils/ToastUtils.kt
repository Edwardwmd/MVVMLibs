package com.edw.mvvmlibs.utils

import android.widget.Toast
import com.edw.mvvmlibs.base.BaseApp

/**
 * Author: EdwardWMD
 * Data: 2021/3/16
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
object ToastUtils {

    fun showToast(msg: String) {
        Toast.makeText(BaseApp.appContext(), msg, Toast.LENGTH_SHORT).show()
    }

}