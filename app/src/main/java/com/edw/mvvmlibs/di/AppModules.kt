package com.edw.mvvmlibs.di


import com.edw.mvvmlibs.net.client.RetrofitClient
import io.reactivex.rxjava3.disposables.CompositeDisposable
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
    RetrofitClient.instance
}

private val baseModule = module {
    factory {
        CompositeDisposable()
    }
}


val appModules = listOf(
    baseModule)

