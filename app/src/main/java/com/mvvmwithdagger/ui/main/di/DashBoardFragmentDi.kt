package com.mvvmwithdagger.ui.main.di

import android.content.Context
import com.mvvmwithdagger.data.remote.ApiServices
import com.mvvmwithdagger.data.repository.DashBoardRepository
import com.mvvmwithdagger.di.AppComponent
import com.mvvmwithdagger.roomdb.MvvmWithDaggerDB
import com.mvvmwithdagger.ui.base.BaseFragmentModule
import com.mvvmwithdagger.ui.base.BaseViewModelFactory
import com.mvvmwithdagger.ui.main.viewmodel.DashBoardViewModel
import com.mvvmwithdagger.ui.main.fragments.dashboard.*
import com.mvvmwithdagger.utils.ApplicationContext
import com.mvvmwithdagger.utils.FragmentScope
import com.mvvmwithdagger.utils.SharedPreference

import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@FragmentScope
@Component(
    dependencies = [AppComponent::class],
    modules = [MyHomeFragmentModule::class, DashBoardFragmentModuleDi::class, BaseFragmentModule::class]
)
interface MyHomeFragmentComponent {
    fun inject(myHomeFragment: MyHomeFragment)
}

@Module(includes = [DashBoardFragmentModuleDi::class])
class MyHomeFragmentModule

@Module
class DashBoardFragmentModuleDi {

    @FragmentScope
    @Provides
    fun provideApiServices(retrofit: Retrofit): ApiServices =
        retrofit.create(ApiServices::class.java)

    @FragmentScope
    @Provides
    fun provideDashBoardRepository(
        apiServices: ApiServices,
        @ApplicationContext context: Context,
        sharedPreference: SharedPreference,
        mvvmWithDaggerDB: MvvmWithDaggerDB
    ): DashBoardRepository =
        DashBoardRepository(apiServices, context, sharedPreference, mvvmWithDaggerDB)

    @FragmentScope
    @Provides
    fun provideViewModelFactory(dashBoardRepository: DashBoardRepository): BaseViewModelFactory<DashBoardViewModel> =
        BaseViewModelFactory { DashBoardViewModel(dashBoardRepository) }

}