package com.edw.mvvmlibs.di

import com.edw.mvvmlibs.viewmodel.NotificationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Author: EdwardWMD
 * Data: 2021/3/16
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * 通知页Module管理
 */
val notifiRepoModule= module {

}

val notifiViewModelModule= module {
    viewModel { NotificationViewModel() }
}