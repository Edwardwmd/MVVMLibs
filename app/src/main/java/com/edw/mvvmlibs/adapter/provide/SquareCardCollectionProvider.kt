package com.edw.mvvmlibs.adapter.provide

import android.text.TextUtils
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.adapter.secondryadapter.SquareBannerAdapter
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.databinding.ItemSquarecardcollectionBinding
import com.edw.mvvmlibs.entity.CollectionItemCard

import com.edw.mvvmlibs.utils.ToastUtils


class SquareCardCollectionProvider : BaseItemProvider<HomeBaseItem>() {

    override val itemViewType: Int
        get() = CardViewType.SQUARE_CARD_COLLECTION

    override val layoutId: Int
        get() = R.layout.item_squarecardcollection

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemSquarecardcollectionBinding>(viewHolder.itemView)
    }


    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {

        item.data?.apply {
            val binding =
                DataBindingUtil.getBinding<ItemSquarecardcollectionBinding>(helper.itemView)
            val squareCardCollection = this as CollectionItemCard
            binding?.run {
                val itemList = squareCardCollection.itemList
                if (itemList != null && itemList.size > 0) {
                    if ("banner2" == itemList[0].type) {
                        recyFollow.visibility = View.GONE
                        bannerSquare.visibility = View.VISIBLE
                        val adapter = SquareBannerAdapter()
                        bannerSquare.setIndicatorVisibility(View.GONE)
                            .setScrollDuration(1200)
                            .setOnPageClickListener { _: View, position: Int ->
                                ToastUtils.showToast("点击了->$position")
                            }
                            .setCanLoop(true)
                            .setAdapter(adapter)
                            .create(itemList)
                    } else if ("followCard" == itemList[0].type) {
                        bannerSquare.visibility = View.GONE
                        recyFollow.visibility = View.VISIBLE
                        val adapter = SquareCardByVideoSmallCardAdapter()
                        recyFollow.layoutManager =
                            LinearLayoutManager(root.context, LinearLayoutManager.VERTICAL, false)
                        recyFollow.setHasFixedSize(true)
                        recyFollow.adapter = adapter
                        adapter.setAllDatas(itemList)
                    }


                }
                if (TextUtils.isEmpty(squareCardCollection.header!!.subTitle)){
                    tvTime.visibility=View.GONE
                }else{
                    tvTime.visibility=View.VISIBLE
                }
                tvTime.typeface=com.edw.mvvmlibs.utils.TextUtils.setTextStyle(com.edw.mvvmlibs.utils.TextUtils.Type.LOBSTER)
                this.squareCardCollection = squareCardCollection
                executePendingBindings()
            }

        }


    }

}
