package com.mvvmwithdagger.ui.main.di

import android.content.Context
import com.mvvmwithdagger.data.remote.ApiServices
import com.mvvmwithdagger.data.repository.DashBoardRepository
import com.mvvmwithdagger.di.AppComponent
import com.mvvmwithdagger.roomdb.MvvmWithDaggerDB
import com.mvvmwithdagger.ui.base.BaseActivityModule
import com.mvvmwithdagger.ui.base.BaseViewModelFactory
import com.mvvmwithdagger.ui.main.activity.DashBoardActivity
import com.mvvmwithdagger.ui.main.viewmodel.DashBoardViewModel
import com.mvvmwithdagger.utils.ActivityScope
import com.mvvmwithdagger.utils.ApplicationContext
import com.mvvmwithdagger.utils.SharedPreference
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [DashBoardActivityModule::class, BaseActivityModule::class]
)
interface DashBoardActivityComponent {
    fun inject(dashBoardActivity: DashBoardActivity)
}

@Module
class DashBoardActivityModule{

    @Provides
    @ActivityScope
    fun provideApiServices(retrofit: Retrofit): ApiServices =
        retrofit.create(ApiServices::class.java)

    @Provides
    @ActivityScope
    fun provideDashBoardRepository(
        apiServices: ApiServices,
        @ApplicationContext context: Context,
        sharedPreference: SharedPreference,
        mvvmWithDaggerDB: MvvmWithDaggerDB
    ): DashBoardRepository =
        DashBoardRepository(apiServices, context, sharedPreference, mvvmWithDaggerDB)

    @ActivityScope
    @Provides
    fun provideViewModelFactory(dashBoardRepository: DashBoardRepository): BaseViewModelFactory<DashBoardViewModel> =
        BaseViewModelFactory { DashBoardViewModel(dashBoardRepository) }
}