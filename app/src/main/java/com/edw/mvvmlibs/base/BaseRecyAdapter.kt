package com.edw.mvvmlibs.base


import androidx.recyclerview.widget.RecyclerView

/**
 * Author: EdwardWMD
 * Data: 2021/3/11
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
abstract class BaseRecyAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    //数据集合
    protected var datas: MutableList<T> = ArrayList()

    //条目点击事件
    private var onItemClickListener: OnItemClickListener<T, VH>? = null

    /**
     * 添加数据
     */
    fun setAllDatas(datas: MutableList<T>?) {
        if (datas == null) return
        this.datas.addAll(datas)
        notifyDataSetChanged()
    }

    /**
     * 清空数据
     */
    fun clearData() {
        if (this.datas.size > 0)
            this.datas.clear()
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            if (onItemClickListener != null) {
                onItemClickListener!!.onItemClick(holder, datas[position], position)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (datas.size <= 0) 0 else datas.size
    }

    interface OnItemClickListener<in T, in VH> {
        fun onItemClick(holder: VH, item: T, position: Int)
    }


    fun setOnItemClickListener(listener: OnItemClickListener<T, VH>) {
        this.onItemClickListener = listener
    }
}