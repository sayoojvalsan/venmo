package com.venmo.di

import com.venmo.home.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
//    @ContributesAndroidInjector
//    abstract fun contributeSignInFragment(): SignInFragment
//
//    @ContributesAndroidInjector
//    abstract fun contributeVerificationFragment(): VerificationCodeFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment


}
