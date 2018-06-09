package com.nizzle94.architecturecomponentmvp.util

import android.support.annotation.AnimRes
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
fun AppCompatActivity.replaceFragmentSafely(fragment: Fragment,
                                            tag: String,
                                            allowStateLoss: Boolean = false,
                                            addToStack: Boolean = false,
                                            backStackNName: String = "",
                                            @IdRes containerViewId: Int,
                                            @AnimRes enterAnimation: Int = 0,
                                            @AnimRes exitAnimation: Int = 0,
                                            @AnimRes popEnterAnimation: Int = 0,
                                            @AnimRes popExitAnimation: Int = 0) {
    val ft = supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(enterAnimation, exitAnimation, popEnterAnimation, popExitAnimation)
            .replace(containerViewId, fragment, tag)
    if (!supportFragmentManager.isStateSaved) {
        ft.commit()
    } else if (allowStateLoss) {
        ft.commitAllowingStateLoss()
    }
    if (addToStack) {
        ft.addToBackStack(backStackNName)
    } else {
        ft.addToBackStack(null)
    }
}

fun AppCompatActivity.addFragmentSafely(fragment: Fragment,
                                        tag: String,
                                        allowStateLoss: Boolean = false,
                                        @IdRes containerViewId: Int,
                                        @AnimRes enterAnimation: Int = 0,
                                        @AnimRes exitAnimation: Int = 0,
                                        @AnimRes popEnterAnimation: Int = 0,
                                        @AnimRes popExitAnimation: Int = 0) {
    val ft = supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(enterAnimation, exitAnimation, popEnterAnimation, popExitAnimation)
            .add(containerViewId, fragment, tag)
    if (!supportFragmentManager.isStateSaved) {
        ft.commit()
    } else if (allowStateLoss) {
        ft.commitAllowingStateLoss()
    }

}