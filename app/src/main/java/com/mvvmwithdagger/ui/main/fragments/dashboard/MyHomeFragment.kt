package com.mvvmwithdagger.ui.main.fragments.dashboard

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.akash.mvvmwithdagger.R
import com.akash.mvvmwithdagger.databinding.FragmentHomeBinding

import com.mvvmwithdagger.di.MvvmWithDaggerSDK
import com.mvvmwithdagger.ui.base.BaseFragment
import com.mvvmwithdagger.ui.base.BaseFragmentModule
import com.mvvmwithdagger.ui.base.BaseViewModelFactory
import com.mvvmwithdagger.ui.main.di.DaggerMyHomeFragmentComponent
import com.mvvmwithdagger.ui.main.di.MyHomeFragmentModule
import com.mvvmwithdagger.ui.main.viewmodel.DashBoardViewModel
import com.mvvmwithdagger.utils.NetworkHelper
import com.mvvmwithdagger.utils.SharedPreference
import javax.inject.Inject


class MyHomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private var instance: MyHomeFragment? = null

    @Inject
    lateinit var progressBar: Dialog

    @Inject
    lateinit var networkHelper: NetworkHelper

    @Inject
    lateinit var sharedPreference: SharedPreference

    @Inject
    lateinit var myHomeViewModelFactory: BaseViewModelFactory<DashBoardViewModel>

    private val viewmodel: DashBoardViewModel by activityViewModels { myHomeViewModelFactory }

    // array for tab labels
    private val labels = arrayOf("My followers", "I’m following...")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instance = this
        DaggerMyHomeFragmentComponent.builder().appComponent(MvvmWithDaggerSDK.appComponent)
            .myHomeFragmentModule(MyHomeFragmentModule())
            .baseFragmentModule(BaseFragmentModule(mActivity)).build().inject(this)

        initialization(view)

    }

    override fun onResume() {
        super.onResume()
        checkInternet()
    }

    private fun initialization(view: View) {
        checkInternet()

    }

    private fun checkInternet() {
        if (networkHelper.isNetworkConnected()) {
            mDataBinding.txtInternet.text = "Internet is connected"
        } else {
            mDataBinding.txtInternet.text = "Internet is not connected"
        }
    }


}