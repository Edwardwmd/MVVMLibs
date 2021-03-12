package com.edw.mvvmlibs.ui.activity

import android.annotation.SuppressLint
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.net.api.Api
import com.edw.mvvmlibs.base.BaseActivity
import com.edw.mvvmlibs.base.BaseVMActivity
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.databinding.ActivityLauncherBinding
import com.edw.mvvmlibs.utils.Constant
import com.edw.mvvmlibs.utils.FontsUtils
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@Route(path = Constant.ACTIVITY_LAUNCHER)
class LauncherActivity : BaseActivity<ActivityLauncherBinding>() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_launcher
    }

    @SuppressLint("SetTextI18n")
    override fun initData() {
        super.initData()
        //加载图片
        Glide
            .with(this)
            .load(Api.LAUNCHER_IMG_URL)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .error(R.drawable.ic_launcher_travel_to_norway)
            .into(binding.ivLauncher)

        //设置字体
        binding.tvLauncherTipsTop.typeface =
            FontsUtils.setTextStyle(FontsUtils.Type.FZLANTINGHEI_L)
        binding.tvLauncherTipsBottom.typeface =
            FontsUtils.setTextStyle(FontsUtils.Type.FZLANTINGHEI_L)
        //跳转主页面

        addDisposed(Flowable
            .intervalRange(0, 3, 0, 1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                binding.skipToMain.text = "倒计时${4 - it}秒"
            }.doOnComplete {
                ARouter.getInstance().build(Constant.ACTIVITY_MAIN).navigation()
                finish()
            }
            .subscribe())

    }
}