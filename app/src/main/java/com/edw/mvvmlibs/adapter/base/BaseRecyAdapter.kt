package com.edw.mvvmlibs.adapter.base


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Author: EdwardWMD
 * Data: 2021/3/11
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
abstract class BaseRecyAdapter<T, DB : ViewDataBinding> :
    RecyclerView.Adapter<BaseRecyAdapter.RecycleViewHolder>() {
    //数据集合
    protected var datas: MutableList<T> = ArrayList()

    //条目点击事件
    private var onItemClickListener: OnItemClickListener<T>? = null

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val rootBinding: DB =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutRes(), parent, false)
        return RecycleViewHolder(rootBinding.root)
    }

    @LayoutRes
    abstract fun layoutRes(): Int


    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val binding: DB? = DataBindingUtil.getBinding(holder.itemView)
        onBindItem(binding,datas[position],position)
        holder.itemView.setOnClickListener {
            if (onItemClickListener != null) {
                onItemClickListener!!.onItemClick(datas[position], position)
            }
        }

    }

    abstract fun onBindItem(binding: DB?, itemBean: T?, position: Int)

    override fun getItemCount(): Int {
        return if (datas.size <= 0) 0 else datas.size
    }

    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }


    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        this.onItemClickListener = listener
    }
}