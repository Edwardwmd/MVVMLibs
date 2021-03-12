package com.edw.mvvmlibs.di

import com.edw.mvvmlibs.base.BaseActivity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.core.qualifier.named
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

private val rxJavaModule = module {
    factory {
        CompositeDisposable()
    }

}

val appModules = listOf(rxJavaModule)

