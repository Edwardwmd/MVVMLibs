package com.edw.mvvmlibs.ui.weight

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import java.util.ArrayDeque

/**
 * Author: EdwardWMD
 * Data: 2021/3/16
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * 重写FragmentNavigator,解决fragment在默认的情况下切换当前fragment时移除上一个fragment,导致切换回来的fragment被重新创建
 */

@Suppress("DEPRECATION", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Navigator.Name("fixFragment") //这句一定要加,在设置navigation XML中添加的每一个fragment都需要以此作为名称
class FixFragmentNavigator constructor(
    private val mC: Context,
    private val manager: FragmentManager,
    private val containerId: Int
) : FragmentNavigator(mC, manager, containerId) {

    private val TAG = this.javaClass.simpleName

    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
        if (manager.isStateSaved) {
            Log.i(TAG, "Ignoring navigate() call: FragmentManager has already" + " saved its state")
            return null
        }
        var className = destination.className
        if (className[0] == '.') {
            className = mC.packageName + className
        }
//        val frag = instantiateFragment(
//            mContext, mFragmentManager,
//            className, args
//        )
//        frag.arguments = args
        val ft = manager.beginTransaction()

        var enterAnim = navOptions?.enterAnim ?: -1
        var exitAnim = navOptions?.exitAnim ?: -1
        var popEnterAnim = navOptions?.popEnterAnim ?: -1
        var popExitAnim = navOptions?.popExitAnim ?: -1
        if (enterAnim != -1 || exitAnim != -1 || popEnterAnim != -1 || popExitAnim != -1) {
            enterAnim = if (enterAnim != -1) enterAnim else 0
            exitAnim = if (exitAnim != -1) exitAnim else 0
            popEnterAnim = if (popEnterAnim != -1) popEnterAnim else 0
            popExitAnim = if (popExitAnim != -1) popExitAnim else 0
            ft.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim)
        }

//       切换Fragment会被创建的原因就在这,FragmentNavigator源码可找到
//        ft.replace(mContainerId, frag)
//        ft.setPrimaryNavigationFragment(frag)

        /**
         *  1、先查询当前显示的fragment 不为空则将其hide
         *  2、根据tag查询当前添加的fragment是否不为null，不为null则将其直接show
         *  3、为null则通过instantiateFragment方法创建fragment实例
         *  4、将创建的实例添加在事务中
         */

        //1.获取当前显示的Fragment,不为空则将其hide
        val mCurrentFragment = manager.primaryNavigationFragment
        if (mCurrentFragment != null) ft.hide(mCurrentFragment)

        //2-3.根据tag查询当前添加的fragment是否为null，不为null则将其直接show,为null则添加到FragmentManager中
        var tagFragment: Fragment?
        val tag = destination.id.toString()
        tagFragment = manager.findFragmentByTag(tag)
        if (tagFragment != null) {
            ft.show(tagFragment)
        } else {
            tagFragment = instantiateFragment(mC, manager, className, args)
            tagFragment.arguments = args
            ft.add(containerId, tagFragment, tag)
        }
        //4.将创建的实例添加在事务中
        ft.setPrimaryNavigationFragment(tagFragment)
        @IdRes val destId = destination.id

        //通过反射获取mBackStack
        val mBackStack: ArrayDeque<Int>?
        val field = FragmentNavigator::class.java.getDeclaredField("mBackStack")
        field.isAccessible = true
        mBackStack = field.get(this) as ArrayDeque<Int>

        val initialNavigation = mBackStack.isEmpty()
        val isSingleTopReplacement = (navOptions != null && !initialNavigation
                && navOptions.shouldLaunchSingleTop()
                && mBackStack.peekLast() == destId)

        val isAdded: Boolean
        if (initialNavigation) {
            isAdded = true
        } else if (isSingleTopReplacement) {
            // Single Top means we only want one instance on the back stack
            if (mBackStack.size > 1) {
                // If the Fragment to be replaced is on the FragmentManager's
                // back stack, a simple replace() isn't enough so we
                // remove it from the back stack and put our replacement
                // on the back stack in its place
                manager.popBackStack(
                    generateBackStackName(mBackStack.size, mBackStack.peekLast()),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
                ft.addToBackStack(generateBackStackName(mBackStack.size, destId))
            }
            isAdded = false
        } else {
            ft.addToBackStack(generateBackStackName(mBackStack.size + 1, destId))
            isAdded = true
        }
        if (navigatorExtras is Extras) {
            val extras = navigatorExtras as Extras?
            for ((key, value) in extras!!.sharedElements) {
                ft.addSharedElement(key, value)
            }
        }
        ft.setReorderingAllowed(true)
        ft.commit()
        // The commit succeeded, update our view of the world
        if (isAdded) {
            mBackStack.add(destId)
            return destination
        } else {
            return null
        }
    }

    /**
     * 在父类是 private的  直接定义一个方法即可
     */
    private fun generateBackStackName(backIndex: Int, destid: Int): String {
        return "$backIndex - $destid"
    }
}