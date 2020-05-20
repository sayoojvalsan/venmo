package com.venmo.di

import com.github.aurae.retrofit2.LoganSquareConverterFactory
import com.venmo.common.adapters.LiveDataCallAdapterFactory
import com.venmo.home.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton


/**
 * Module which provides all required dependencies about network
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
class NetworkModule {

    /**
     * Provides the Registration service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Post service implementation.
     */
//    @Provides
//    @Reusable
//    internal fun provideRegistrationApi(retrofit: Retrofit): IRegistrationApi {
//        return retrofit.create(IRegistrationApi::class.java)
//    }

//    /**
//     * Provides the Registration service implementation.
//     * @param retrofit the Retrofit object used to instantiate the service
//     * @return the Post service implementation.
//     */
//    @Provides
//    @Reusable
//    internal fun providesUserApi(retrofit: Retrofit): IUserApi {
//        return retrofit.create(IUserApi::class.java)
//    }


//    /**
//     * Provides the Post service implementation.
//     * @param retrofit the Retrofit object used to instantiate the service
//     * @return the Post service implementation.
//     */
//    @Provides
//    internal fun provideRegistrationService(registationService: RegistrationServiceImpl): IRegistrationService {
//        return registationService
//    }

//
//    /**
//     * Provides the User service implementation.
//     * @param retrofit the Retrofit object used to instantiate the service
//     * @return the Post service implementation.
//     */
//    @Provides
//    internal fun provideUserService(userService: UserServiceImpl): IUserService {
//        return userService
//    }


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addInterceptor(logging)
        }

        okHttpBuilder.addInterceptor { chain ->
            Timber.d("Inside interceptor")
            val original: Request = chain.request()
            val request: Request.Builder = original.newBuilder()
            runBlocking {
                request.apply {
                    Timber.d(" interceptor inside apply headers")
                    this.addHeader("Content-Type", "application/json")
                }.build()
            }
            Timber.d(" interceptor done")
            chain.proceed(request.build())
        }
        val client: OkHttpClient = okHttpBuilder.build()

            return Retrofit.Builder()
            .baseUrl(BASE_URL)
                .addConverterFactory(LoganSquareConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }




    companion object {
        const val BASE_URL: String = "https://qa-api.romio.com"
    }


}