package com.edw.mvvmlibs.di

import com.edw.mvvmlibs.viewmodel.FollowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Author: EdwardWMD
 * Data: 2021/3/16
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * 关注页Module管理
 */
val followRepoModule= module {

}

val followViewModelModule= module {
    viewModel { FollowViewModel() }
}