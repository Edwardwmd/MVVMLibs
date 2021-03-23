package com.edw.mvvmlibs.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

/**
 * Author: EdwardWMD
 * Data: 2021/3/16
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
object TimeUtils {

    fun currentTimes(): Long {
        return System.currentTimeMillis()
    }

    @SuppressLint("SimpleDateFormat")
    fun currentData(time: Long): String {
        val simpleDateFormat = SimpleDateFormat("yyyy.MM.DD")
        return simpleDateFormat.format(Date(time))
    }
}