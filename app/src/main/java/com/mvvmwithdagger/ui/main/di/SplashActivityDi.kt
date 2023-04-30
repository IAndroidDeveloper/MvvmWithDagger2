package com.mvvmwithdagger.ui.main.di

import android.content.Context
import com.mvvmwithdagger.data.remote.ApiServices
import com.mvvmwithdagger.data.repository.SplashRepository
import com.mvvmwithdagger.di.AppComponent
import com.mvvmwithdagger.roomdb.MvvmWithDaggerDB
import com.mvvmwithdagger.ui.base.BaseActivityModule
import com.mvvmwithdagger.ui.base.BaseViewModelFactory
import com.mvvmwithdagger.ui.main.activity.SplashActivity
import com.mvvmwithdagger.ui.main.viewmodel.SplashViewModel
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
    modules = [SplashModule::class, BaseActivityModule::class]
)
interface SplashComponent {
    fun inject(splashActivity: SplashActivity)
}

@Module
class SplashModule {

    @Provides
    @ActivityScope
    fun provideApiServices(retrofit: Retrofit): ApiServices =
        retrofit.create(ApiServices::class.java)

    @Provides
    @ActivityScope
    fun provideLoginRepository(
        apiServices: ApiServices,
        @ApplicationContext context: Context,
        sharedPreference: SharedPreference,
        mvvmWithDaggerDB: MvvmWithDaggerDB
    ): SplashRepository =
        SplashRepository(apiServices, context, sharedPreference, mvvmWithDaggerDB)

    @ActivityScope
    @Provides
    fun provideViewModelFactory(splashRepository: SplashRepository): BaseViewModelFactory<SplashViewModel> =
        BaseViewModelFactory { SplashViewModel(splashRepository) }
}