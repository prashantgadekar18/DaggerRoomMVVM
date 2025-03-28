package com.pg.mvvmwithdagger2example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pg.mvvmwithdagger2example.models.Product

@Database(entities = [Product::class], version = 2)
abstract class ProductDB : RoomDatabase(){
    abstract fun getProductDAO(): ProductDAO
}