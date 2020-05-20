package com.venmo.di

import android.app.Application
import com.venmo.utils.AppPrefs
import com.venmo.utils.ModelPreferencesManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//see https://github.com/Eli-Fox/LEGO-Catalog for Dagger reference
@Module(includes = [ViewModelModule::class, NetworkModule::class])
class AppModule {

    @Provides
    @Singleton
    internal fun provideSharedPref(application: Application): AppPrefs {
        return AppPrefs(application)
    }

    @Provides
    @Singleton
    internal fun provideModelPrefManager(appPrefs: AppPrefs) : ModelPreferencesManager {
        return ModelPreferencesManager(appPrefs)
    }


}