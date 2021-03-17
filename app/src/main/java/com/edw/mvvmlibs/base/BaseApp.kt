package com.edw.mvvmlibs.base

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * Author: EdwardWMD
 * Data: 2021/3/9
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */

open class BaseApp : Application() {
    companion object {
       private var mC: Context by Delegates.notNull()
        fun appContext(): Context = mC.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        mC = this.applicationContext
    }



}