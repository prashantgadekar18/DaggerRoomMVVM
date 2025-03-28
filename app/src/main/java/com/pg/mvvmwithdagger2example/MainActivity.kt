package com.pg.mvvmwithdagger2example

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pg.mvvmwithdagger2example.adapter.ProductListAdapter
import com.pg.mvvmwithdagger2example.db.ProductDB
import com.pg.mvvmwithdagger2example.models.Product
import com.pg.mvvmwithdagger2example.viewmodels.MainViewModel
import com.pg.mvvmwithdagger2example.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    @Inject
    lateinit var productDB: ProductDB

    @Inject
    lateinit var productDB1: ProductDB

    private val tv_products : TextView
        get() = findViewById(R.id.tv_products)

    private val rvProductList : RecyclerView
        get() = findViewById(R.id.rvProductList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        (application as MyApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)


        mainViewModel.productsLiveData.observe(this, Observer {

            setRecyclerView(it)
           tv_products.text =  it.joinToString { x -> x.title + "\n\n" }
        })

    }

    private fun setRecyclerView(productList: List<Product>?) {
        val productAdapter = ProductListAdapter(productList !!)
        rvProductList.layoutManager = LinearLayoutManager(this)
        rvProductList.adapter = productAdapter

    }
}