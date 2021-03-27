package com.edw.mvvmlibs.ui.fragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseFragment
import com.edw.mvvmlibs.databinding.FragmentHomeBinding
import com.edw.mvvmlibs.utils.TextUtils
import com.edw.mvvmlibs.utils.ToastUtils
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val tabsLabel = arrayOf("发现", "推荐", "日报")

    private var mediator: TabLayoutMediator? = null

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
        binding.tvLogoName.typeface = TextUtils.setTextStyle(TextUtils.Type.REFLISATTA)

        //水平viewpage
        binding.vpHome.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        //禁用预加载
        binding.vpHome.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT

        binding.vpHome.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return tabsLabel.size
            }

            override fun createFragment(position: Int): Fragment {
                var fragment: Fragment? = null
                when (position) {
                    0 -> fragment = DiscoveryFragment.getInstance()
                    1 -> fragment = RecommendFragment.getInstance()
                    2 -> fragment = DailyFragment.getInstance()
                }
                return fragment!!
            }

        }

        mediator = TabLayoutMediator(
            binding.tab, binding.vpHome
        ) { tab, position ->
            //设置标题
            tab.text = tabsLabel[position]
        }
        mediator!!.attach()
    }

    override fun initEvent() {
//        binding.vpHome.registerOnPageChangeCallback(callback)
        binding.ivAllCategory.setOnClickListener {
            ToastUtils.showToast("我被点击了")
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mediator!!.detach()
    }
}