package com.edw.mvvmlibs.base

import android.os.Bundle
import androidx.annotation.LayoutRes


import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.edw.mvvmlibs.utils.StatusBarUtils
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import org.koin.android.ext.android.inject


/**
 * Author: EdwardWMD
 * Data: 2021/3/9
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc:所有Activity的基类
 */

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    private val disposable: CompositeDisposable by inject()

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //实现沉浸式状态栏
//        StatusBarUtils.fixSystemBar(this)
        //初始化Databinding
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        //如果不继承BaseVMActivity可重写此方法
        initView()

        initData()
    }

    open fun initData() {}

    open fun initView() {}

    open fun addDisposed(disposable: Disposable) {
        this.disposable.add(disposable)
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int


    override fun onDestroy() {
        super.onDestroy()
        if (!disposable.isDisposed)
            disposable.dispose()

        binding.unbind()
    }

}

