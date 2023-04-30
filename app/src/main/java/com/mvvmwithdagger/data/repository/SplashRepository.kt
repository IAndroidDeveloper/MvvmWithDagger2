package com.mvvmwithdagger.data.repository

import android.content.Context
import com.mvvmwithdagger.data.remote.ApiServices
import com.mvvmwithdagger.roomdb.MvvmWithDaggerDB
import com.mvvmwithdagger.ui.base.BaseRepository
import com.mvvmwithdagger.utils.SharedPreference

class SplashRepository(
    val apiServices: ApiServices,
    val context: Context,
    val sharedPreferences: SharedPreference,
    val partsAndPlanesDB: MvvmWithDaggerDB
) : BaseRepository() {

}