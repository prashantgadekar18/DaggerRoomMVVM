package com.pg.mvvmwithdagger2example

import android.app.Application
import com.pg.mvvmwithdagger2example.di.ApplicationComponent
import com.pg.mvvmwithdagger2example.di.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}