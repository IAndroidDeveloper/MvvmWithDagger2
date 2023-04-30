package com.mvvmwithdagger.di

import android.app.Application
import com.mvvmwithdagger.ui.base.BaseSdk

object MvvmWithDaggerSDK : BaseSdk() {
    private var mApplication: Application? = null
    lateinit var appComponent: AppComponent

    fun initialize(mApplication: Application): MvvmWithDaggerSDK {
        MvvmWithDaggerSDK.mApplication = mApplication
        appComponent = DaggerAppComponent.builder().appModule(AppModule(mApplication)).build()
        appComponent.inject(this)
        return this
    }

}