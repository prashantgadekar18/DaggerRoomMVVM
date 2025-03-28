package com.pg.mvvmwithdagger2example.di

import com.pg.mvvmwithdagger2example.models.Product
import com.pg.mvvmwithdagger2example.retrofit.ProductAPI
import com.pg.mvvmwithdagger2example.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesProductAPI(retrofit: Retrofit) : ProductAPI{
        return retrofit.create(ProductAPI::class.java)
    }
}