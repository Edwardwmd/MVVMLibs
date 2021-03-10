package com.edw.mvvmlibs.ui.activity



import com.edw.mvvmlibs.MartialArts
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVMActivity
import com.edw.mvvmlibs.databinding.ActivityMainBinding


class MainActivity : BaseVMActivity<ActivityMainBinding>() {
    override fun getLayoutRes(): Int {
       return R.layout.activity_main
    }


    override fun initView() {
       binding.apply {
           martialArts= MartialArts("张无忌", 22, "男", "乾坤大挪移", "非常强")
       }
    }

    override fun initData() {

    }

    override fun initViewModel() {

    }


}