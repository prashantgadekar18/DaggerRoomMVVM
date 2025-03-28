package com.pg.mvvmwithdagger2example.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pg.mvvmwithdagger2example.models.Product

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProducts(products : List<Product>)
    @Query("SELECT * FROM product")
    suspend fun getProducts() :  List<Product>
}