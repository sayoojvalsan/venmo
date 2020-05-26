package com.venmo.di

import android.app.Activity
import android.app.Application
import com.venmo.home.BuildConfig
import com.venmo.home.di.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AppModule::class,
    MainActivityModule::class])
interface ApplicationComponent {

    fun inject(application: VenmoApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }


}

class VenmoApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    override fun activityInjector() = dispatchingAndroidInjector
}