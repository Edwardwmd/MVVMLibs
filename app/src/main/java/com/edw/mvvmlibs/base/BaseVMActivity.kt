package com.edw.mvvmlibs.base


import android.os.Bundle
import androidx.annotation.LayoutRes

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel


import com.edw.mvvmlibs.utils.StatusBarUtils
import org.koin.androidx.viewmodel.compat.ViewModelCompat.getViewModel


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
        //沉浸式app页面(全屏窗口)
        StatusBarUtils.fixSystemBar(this)
        //初始化DataBinding
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        //初始化ViewModel
        initViewModel()

        initData()

        //观察数据变化,更新数据到UI
        observeData()

        //初始化事件
        initEvent()
    }

    open fun initData() {}

    @LayoutRes
    abstract fun getLayoutRes(): Int

    private fun initViewModel() {
        //使用Koin依赖注入获取ViewModel
        vm=getViewModel(this,getViewModelClass())
    }

    abstract fun getViewModelClass(): Class<VM>

    open fun observeData() {}

    open fun initEvent() {}

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

}