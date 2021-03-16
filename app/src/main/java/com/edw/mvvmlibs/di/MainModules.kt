package com.edw.mvvmlibs.di

import com.edw.mvvmlibs.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Author: EdwardWMD
 * Data: 2021/3/16
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * MainActivity Module管理
 */
val mainRepoModule = module {

}

val mainViewModelModule = module {
    viewModel {
        MainViewModel()
    }
}