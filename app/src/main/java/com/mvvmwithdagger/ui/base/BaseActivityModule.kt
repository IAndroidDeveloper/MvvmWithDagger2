package com.mvvmwithdagger.ui.base

import android.app.Dialog
import android.content.Context
import com.mvvmwithdagger.utils.ActivityContext
import com.mvvmwithdagger.utils.ActivityScope
import com.mvvmwithdagger.utils.ApplicationContext
import com.mvvmwithdagger.utils.Utility
import dagger.Module
import dagger.Provides

/**
 * Extentia
 * PUNE.
 */
@Module
open class BaseActivityModule(private val context: Context) {

        /**
         * common progressbar dependency
         */
        @Provides
        @ActivityScope
        fun getProgressBar(@ApplicationContext context: Context):Dialog= Utility.showCommonProgressDialog(context)

       @ActivityContext
       @Provides
       @ActivityScope
       fun getActivityContext()=context
}