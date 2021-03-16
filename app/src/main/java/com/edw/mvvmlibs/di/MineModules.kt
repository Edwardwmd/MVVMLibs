package com.edw.mvvmlibs.di

import com.edw.mvvmlibs.viewmodel.MineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Author: EdwardWMD
 * Data: 2021/3/16
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * 我的页面Module管理
 */
val mineRepoModule = module {

}
val mineViewModelModule = module {
    viewModel { MineViewModel() }
}