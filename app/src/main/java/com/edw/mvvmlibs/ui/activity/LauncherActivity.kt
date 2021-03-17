package com.edw.mvvmlibs.ui.activity

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseActivity
import com.edw.mvvmlibs.databinding.ActivityLauncherBinding
import com.edw.mvvmlibs.utils.Constant
import com.edw.mvvmlibs.utils.FontsUtils
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.android.ext.android.inject
import java.util.concurrent.TimeUnit

@Route(path = Constant.ACTIVITY_LAUNCHER)
class LauncherActivity : BaseActivity<ActivityLauncherBinding>() {

    private val animator: ValueAnimator by inject()

    private val count=5L

    override fun getLayoutRes(): Int {
        return R.layout.activity_launcher
    }

    override fun initView() {

        //设置字体
        binding.tvLauncherTipsTop.typeface =
            FontsUtils.setTextStyle(FontsUtils.Type.FZLANTINGHEI_L)
        binding.tvLauncherTipsBottom.typeface =
            FontsUtils.setTextStyle(FontsUtils.Type.FZLANTINGHEI_L)

        animator.addUpdateListener {
            //针对XY轴进行缩放
            binding.ivLauncher.scaleX=it.animatedValue as Float
            binding.ivLauncher.scaleY=it.animatedValue as Float
        }
        animator.start()
    }

    @SuppressLint("SetTextI18n")
    override fun initData() {
        //跳转主页面
        //从0开始发射5个数字为：0-4依次输出，延时0s执行，每1s发射一次。
        addDisposed(Flowable
            .intervalRange(0, count, 0, 1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                binding.skipToMain.text = "倒计时${count-1 - it}秒"
            }.doOnComplete {
                //跳转至MainActivity
                ARouter.getInstance().build(Constant.ACTIVITY_MAIN).navigation()
                finish()
            }
            .subscribe())

    }

    override fun onDestroy() {
        super.onDestroy()
        animator.cancel()
        animator.removeAllListeners()

    }
}