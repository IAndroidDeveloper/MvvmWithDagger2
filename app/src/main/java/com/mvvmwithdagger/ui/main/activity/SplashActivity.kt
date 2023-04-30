package com.mvvmwithdagger.ui.main.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.viewModels
import com.akash.mvvmwithdagger.R
import com.akash.mvvmwithdagger.databinding.ActivitySplashBinding
import com.mvvmwithdagger.di.MvvmWithDaggerSDK
import com.mvvmwithdagger.ui.base.BaseActivity
import com.mvvmwithdagger.ui.base.BaseActivityModule
import com.mvvmwithdagger.ui.base.BaseViewModelFactory
import com.mvvmwithdagger.ui.main.di.DaggerSplashComponent
import com.mvvmwithdagger.ui.main.di.SplashModule
import com.mvvmwithdagger.ui.main.viewmodel.SplashViewModel
import com.mvvmwithdagger.utils.NetworkHelper
import com.mvvmwithdagger.utils.SharedPreference
import javax.inject.Inject


class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    @Inject
    lateinit var networkHelper: NetworkHelper

    @Inject
    lateinit var sharedPreference: SharedPreference

    @Inject
    lateinit var splashViewModelFactory: BaseViewModelFactory<SplashViewModel>
    private val viewmodel: SplashViewModel by viewModels { splashViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializationDagger();
        initialization()
    }

    private fun initializationDagger() {
        DaggerSplashComponent.builder().appComponent(MvvmWithDaggerSDK.appComponent)
            .splashModule(SplashModule())
            .baseActivityModule(BaseActivityModule(this@SplashActivity)).build().inject(this)
    }

    private fun initialization() {
        viewDataBinding?.progressView?.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(applicationContext, DashBoardActivity::class.java))
                finish()
            }, 3000
        )
    }

}