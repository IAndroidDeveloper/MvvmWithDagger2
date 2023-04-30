package com.mvvmwithdagger.ui.base

import com.mvvmwithdagger.utils.SharedPreference
import javax.inject.Inject

open class BaseSdk {
    @Inject
    lateinit var sharedPreference: SharedPreference
}