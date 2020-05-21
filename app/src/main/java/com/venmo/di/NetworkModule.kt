package com.venmo.di

import com.github.aurae.retrofit2.LoganSquareConverterFactory
import com.venmo.common.adapters.LiveDataCallAdapterFactory
import com.venmo.home.api.ISearchApi
import com.venmo.home.api.ISearchService
import com.venmo.home.api.SearchServiceImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.coroutines.runBlocking
import kotterknife.BuildConfig
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



    @Provides
    @Reusable
    internal fun providesSearchApi(retrofit: Retrofit): ISearchApi {
        return retrofit.create(ISearchApi::class.java)
    }



    @Provides
    internal fun provideSearchService(searchServiceImpl: SearchServiceImpl): ISearchService {
        return searchServiceImpl
    }

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
        const val BASE_URL: String = "https://itunes.apple.com"
    }


}