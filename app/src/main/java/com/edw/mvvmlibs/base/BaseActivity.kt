package com.edw.mvvmlibs.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.LayoutRes


import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBinderMapperImpl
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.edw.mvvmlibs.databinding.ActivityBaseBinding
import java.lang.Exception
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KProperty


/**
 * Author: EdwardWMD
 * Data: 2021/3/9
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc:所有Activity的基类
 */

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //初始化Databinding
        binding = DataBindingUtil.setContentView(this, getLayoutRes())

    }

    @LayoutRes
    abstract fun getLayoutRes(): Int




}

