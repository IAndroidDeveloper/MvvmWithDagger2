package com.mvvmwithdagger.data.repository

import android.content.Context
import com.mvvmwithdagger.data.remote.ApiServices
import com.mvvmwithdagger.roomdb.MvvmWithDaggerDB
import com.mvvmwithdagger.ui.base.BaseRepository
import com.mvvmwithdagger.utils.SharedPreference

class DashBoardRepository
    (
    private val apiServices: ApiServices,
    val context: Context,
    private val sharedPreferences: SharedPreference,
    private val mvvmWithDaggerDB: MvvmWithDaggerDB
) : BaseRepository() {

}