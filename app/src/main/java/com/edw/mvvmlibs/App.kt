package com.edw.mvvmlibs

import com.alibaba.android.arouter.launcher.ARouter
import com.edw.mvvmlibs.base.BaseApp
import com.edw.mvvmlibs.di.appModules

import com.edw.mvvmlibs.viewmodel.*

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

/**
 * Author: EdwardWMD
 * Data: 2021/3/9
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Appliactaion
 */
class App : BaseApp() {

    lateinit var mKoin: KoinApplication

    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
        //Kotlin依赖注入
        initKoin()
    }

    private fun initKoin() {
        mKoin = startKoin {
            androidContext(this@App)
            androidLogger(level = Level.INFO)
            modules(appModules)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        mKoin.close()
    }
}