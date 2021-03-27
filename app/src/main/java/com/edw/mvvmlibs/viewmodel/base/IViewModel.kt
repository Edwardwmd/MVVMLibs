package com.edw.mvvmlibs.viewmodel.base

import androidx.lifecycle.MutableLiveData
import com.edw.mvvmlibs.entity.ResultData
import com.edw.mvvmlibs.utils.LoadState

/**
 * Author: EdwardWMD
 * Data: 2021/3/27
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
interface IViewModel {
    fun loadData(page:Int=0,date:Long=0,num:Int=0)

}