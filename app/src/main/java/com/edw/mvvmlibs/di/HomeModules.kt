package com.edw.mvvmlibs.di

import com.edw.mvvmlibs.net.client.RetrofitClient
import com.edw.mvvmlibs.net.repository.HomeRepository
import com.edw.mvvmlibs.viewmodel.DailyViewModel
import com.edw.mvvmlibs.viewmodel.DiscoveryViewModel
import com.edw.mvvmlibs.viewmodel.RecommendViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Author: EdwardWMD
 * Data: 2021/3/16
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * 主页Module管理
 */

val homeRepoModule = module {
    single { HomeRepository(retrofit = get()) }

}

val homeViewModelModule = module {
    viewModel { DiscoveryViewModel(repository = get()) }
    viewModel { RecommendViewModel() }
    viewModel { DailyViewModel() }

}