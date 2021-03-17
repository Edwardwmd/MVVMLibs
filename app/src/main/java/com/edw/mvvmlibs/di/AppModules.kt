package com.edw.mvvmlibs.di


import android.animation.FloatEvaluator
import android.animation.ValueAnimator
import com.edw.mvvmlibs.net.client.RetrofitClient
import com.edw.mvvmlibs.utils.Constant
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.dsl.module

/**
 * Author: EdwardWMD
 * Data: 2021/3/10
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * 所有依赖module管理
 */

//room数据库依赖注入
private val roomModule = module {

}
val launcherModule= module {

    factory { ValueAnimator.ofObject(FloatEvaluator(),1.0F,1.2F).setDuration(Constant.ANIM_DRUATION) }
}

 val otherModule = module {
    factory { CompositeDisposable()}
    single { RetrofitClient.instance }
}

val appModules = listOf(
    launcherModule,
    otherModule,
    mainViewModelModule,
    homeRepoModule, homeViewModelModule,
    followViewModelModule,
    notifiViewModelModule,
    mineViewModelModule
)

