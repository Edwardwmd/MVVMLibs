package com.edw.mvvmlibs.base


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.edw.mvvmlibs.utils.StatusBarUtils



/**
 * Author: EdwardWMD
 * Data: 2021/3/10
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: 使用ViewModel实现MVVM的Activity的基类
 */
abstract class BaseVMActivity<T : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {
    lateinit var vm: VM
    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.fixSystemBar(this)
        //初始化DataBinding
        binding = DataBindingUtil.setContentView<T>(this, getLayoutRes())
        //初始化ViewModel
        initViewModel()
        //观察数据变化,更新数据到UI
        observeData()
        //初始化事件
        initEvent()
    }

    abstract fun getLayoutRes(): Int

    private fun initViewModel() {
        vm = ViewModelProvider(this).get(getViewModelClass())
    }

    abstract fun getViewModelClass(): Class<VM>

    open fun observeData() {}

    open fun initEvent() {}

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

}