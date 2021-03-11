package com.edw.mvvmlibs.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Author: EdwardWMD
 * Data: 2021/3/10
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: 使用ViewModel实现MVVM的Fragment的基类
 */
abstract class BaseVmFragment<T:ViewDataBinding, VM : ViewModel> : BaseFragment<T>() {

    protected lateinit var vm: VM

    /**
     * Android将对onActivityCreated弃用,使用onViewCreated代替onActivityCreated
     * 为了解决fragment与Activity之间的特殊耦合
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //创建ViewModel
        initViewModel()
        //观察数据变化,更新数据
        observeData()
        //设置事件
        initEvent()

    }

    open fun initEvent() {}

    open fun observeData() {}

    private fun initViewModel() {
        vm = ViewModelProvider(this).get(getViewModelClazz())
    }

    abstract fun getViewModelClazz(): Class<VM>


}