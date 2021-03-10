package com.edw.mvvmlibs.ui.activity




import com.edw.mvvmlibs.MainViewModel
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVMActivity
import com.edw.mvvmlibs.bean.MartialArts
import com.edw.mvvmlibs.databinding.ActivityMainBinding


class MainActivity : BaseVMActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutRes(): Int {
       return R.layout.activity_main
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun observeData() {
        super.observeData()
       binding.martialArts= MartialArts("张无忌", 22, "男", "乾坤大挪移", "非常强")
    }


}