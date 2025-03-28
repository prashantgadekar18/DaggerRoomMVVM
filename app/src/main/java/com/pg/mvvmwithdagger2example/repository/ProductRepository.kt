package com.pg.mvvmwithdagger2example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pg.mvvmwithdagger2example.db.ProductDB
import com.pg.mvvmwithdagger2example.models.Product
import com.pg.mvvmwithdagger2example.retrofit.ProductAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productAPI: ProductAPI,
    private val productDB: ProductDB) {

    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>>
        get() = _products
    suspend fun getProducts(){
        val result = productAPI.getProductList()
        if (result.isSuccessful && result.body() != null){
            productDB.getProductDAO().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }
}