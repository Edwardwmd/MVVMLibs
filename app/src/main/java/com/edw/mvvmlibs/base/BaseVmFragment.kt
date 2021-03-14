@file:Suppress("UNCHECKED_CAST")

package com.edw.mvvmlibs.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass


/**
 * Author: EdwardWMD
 * Data: 2021/3/10
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: 使用ViewModel实现MVVM的Fragment的基类
 */
abstract class BaseVmFragment<T : ViewDataBinding, VM : ViewModel> : Fragment() {

    protected lateinit var vm: VM

    protected lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        return binding.root
    }


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
        //加载数据
        startLoadData()
        //设置事件
        initEvent()

    }

    open fun startLoadData(){}

    open fun initEvent() {}

    open fun observeData() {}

    @SuppressLint("NewApi")
    private fun initViewModel() {
        vm = ViewModelProvider(this).get(getViewModelClazz())
    }

    abstract fun getViewModelClazz(): Class<VM>

    @LayoutRes
    abstract fun getLayoutRes(): Int


    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
}