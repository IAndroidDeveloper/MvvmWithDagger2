package com.mvvmwithdagger

import android.app.Application
import com.mvvmwithdagger.di.MvvmWithDaggerSDK

class App :Application() {

    override fun onCreate() {
        super.onCreate()
        MvvmWithDaggerSDK.initialize(this)
    }
}