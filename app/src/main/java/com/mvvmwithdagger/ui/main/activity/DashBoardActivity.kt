package com.mvvmwithdagger.ui.main.activity

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.akash.mvvmwithdagger.R
import com.akash.mvvmwithdagger.databinding.ActivityDashboardBinding
import com.google.android.material.navigation.NavigationView
import com.mvvmwithdagger.di.MvvmWithDaggerSDK
import com.mvvmwithdagger.ui.base.BaseActivity
import com.mvvmwithdagger.ui.base.BaseActivityModule
import com.mvvmwithdagger.ui.base.BaseViewModelFactory
import com.mvvmwithdagger.ui.main.di.DaggerDashBoardActivityComponent
import com.mvvmwithdagger.ui.main.di.DashBoardActivityModule
import com.mvvmwithdagger.ui.main.viewmodel.DashBoardViewModel
import com.mvvmwithdagger.utils.NetworkHelper
import com.mvvmwithdagger.utils.SharedPreference
import javax.inject.Inject


class DashBoardActivity :
    BaseActivity<ActivityDashboardBinding>(R.layout.activity_dashboard),
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController


    @Inject
    lateinit var networkHelper: NetworkHelper

    @Inject
    lateinit var sharedPreference: SharedPreference

    @Inject
    lateinit var dashBoardViewModelFactory: BaseViewModelFactory<DashBoardViewModel>
    private val viewmodel: DashBoardViewModel by viewModels { dashBoardViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializationDagger()
        initialization()


    }

    private fun initializationDagger() {
        DaggerDashBoardActivityComponent.builder().appComponent(MvvmWithDaggerSDK.appComponent)
            .dashBoardActivityModule(DashBoardActivityModule())
            .baseActivityModule(BaseActivityModule(this@DashBoardActivity)).build()
            .inject(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val imm =
            applicationContext?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return true
    }

    private fun initialization() {


    }



    private fun getCurrentFragment(): Fragment {
        val navHostFragment = supportFragmentManager.primaryNavigationFragment
        return navHostFragment!!.childFragmentManager.fragments[0];
    }

    fun setCustomTitle(title: String) {
        TODO("Not yet implemented")
    }

    private fun jumpToAnotherFragment(navigationTaskProfile: Int) {
        navController.navigate(navigationTaskProfile)
    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}

