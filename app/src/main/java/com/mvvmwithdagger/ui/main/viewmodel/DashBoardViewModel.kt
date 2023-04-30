package com.mvvmwithdagger.ui.main.viewmodel

import com.mvvmwithdagger.data.repository.DashBoardRepository
import com.mvvmwithdagger.ui.base.BaseViewModel
import javax.inject.Inject


class DashBoardViewModel @Inject constructor(private val dashBoardRepository: DashBoardRepository) :
    BaseViewModel() {

}