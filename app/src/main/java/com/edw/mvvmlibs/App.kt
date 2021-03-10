package com.edw.mvvmlibs

import com.edw.mvvmlibs.base.BaseApp
import com.edw.mvvmlibs.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Author: EdwardWMD
 * Data: 2021/3/9
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Appliactaion
 */
class App : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        //Kotlin依赖注入
//        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            printLogger(level = Level.INFO)
            modules(appModules)

        }
    }


}