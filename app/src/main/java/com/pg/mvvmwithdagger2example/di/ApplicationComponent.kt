package com.pg.mvvmwithdagger2example.di

import android.content.Context
import com.pg.mvvmwithdagger2example.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)


    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}