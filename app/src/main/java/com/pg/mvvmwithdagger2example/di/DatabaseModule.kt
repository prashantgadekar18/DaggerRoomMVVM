package com.pg.mvvmwithdagger2example.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pg.mvvmwithdagger2example.db.ProductDB
import com.pg.mvvmwithdagger2example.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getProductDB(context: Context) : ProductDB{
        return Room.databaseBuilder(context, ProductDB::class.java, Constants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}