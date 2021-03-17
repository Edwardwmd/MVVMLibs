package com.edw.mvvmlibs.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.edw.mvvmlibs.ui.weight.WindowFrameLayout

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class FixNavHostFragment:NavHostFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val windowFrameLayout = WindowFrameLayout(inflater.context)
        windowFrameLayout.id=id
        return windowFrameLayout
    }

}