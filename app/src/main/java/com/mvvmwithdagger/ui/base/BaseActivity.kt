package com.mvvmwithdagger.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Akash.Singh
 * MOHALI.
 */
abstract class BaseActivity<VB : ViewDataBinding>(@LayoutRes val layoutRes: Int) : AppCompatActivity() {

    protected var viewDataBinding: VB? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this,layoutRes)
    }

    fun showMessage(message: String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }
}