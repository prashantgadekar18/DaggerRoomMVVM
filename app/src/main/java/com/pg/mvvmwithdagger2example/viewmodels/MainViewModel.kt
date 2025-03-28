package com.pg.mvvmwithdagger2example.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pg.mvvmwithdagger2example.models.Product
import com.pg.mvvmwithdagger2example.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    val productsLiveData : LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch{
            repository.getProducts()
        }
    }
}