package com.edw.mvvmlibs.di

import org.koin.dsl.module

/**
 * Author: EdwardWMD
 * Data: 2021/3/10
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */

//room数据库依赖注入
private val roomModule = module {

}

//retrofitDepository网络仓库的依赖注入
private val retrofitModule = module {

}


val appModules = listOf(roomModule, retrofitModule)

