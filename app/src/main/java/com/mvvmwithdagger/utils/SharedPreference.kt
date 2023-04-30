package com.mvvmwithdagger.utils

import android.content.Context
import javax.inject.Inject

/**
 * Akash.Singh
 * MOHALI.
 */
class SharedPreference @Inject constructor(context: Context) {
    private val PREFS_NAME = "mvvm_with_dagger_pref_file"
    private val pref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)!!

}