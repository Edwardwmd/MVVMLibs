package com.edw.mvvmlibs.base

import android.os.Bundle
import androidx.databinding.Observable
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Author: EdwardWMD
 * Data: 2021/3/10
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: 使用ViewModel实现MVVM的Activity的基类
 */
abstract class BaseVMActivity<T : ViewDataBinding, VM : ViewModel> : BaseActivity<T>() {
    protected lateinit var vm: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //初始化ViewModel
        initViewModel()
       //观察数据变化,更新数据到UI
        observeData()
        //初始化事件
        initEvent()
    }

    private fun initViewModel() {
        vm = ViewModelProvider(this).get(getViewModelClass())
    }

    abstract fun getViewModelClass(): Class<VM>

    open fun observeData() {}

    open fun initEvent(){}



}