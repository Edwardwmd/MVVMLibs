package com.edw.mvvmlibs.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.edw.mvvmlibs.base.BaseRecyAdapter
import com.edw.mvvmlibs.bean.HomeBaseItem

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class MutilTypeAdapter : BaseRecyAdapter<HomeBaseItem, RecyclerView.ViewHolder>() {

//    enum class ItemType(type:String){
//
//
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return datas[position].type.hashCode()
    }

}