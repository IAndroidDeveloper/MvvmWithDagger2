package com.mvvmwithdagger.ui.base

import android.app.Dialog
import android.content.Context
import com.mvvmwithdagger.utils.FragmentScope
import com.mvvmwithdagger.utils.Utility
import dagger.Module
import dagger.Provides

/**
 * Extentia
 * PUNE.
 */

@Module
 class BaseFragmentModule(private val context: Context){
    /**
     * common progressbar dependency
     */
    @Provides
    @FragmentScope
    fun getProgressBar(): Dialog = Utility.showCommonProgressDialog(context)

}