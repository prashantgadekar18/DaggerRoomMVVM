package com.pg.mvvmwithdagger2example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pg.mvvmwithdagger2example.R
import com.pg.mvvmwithdagger2example.models.Product

class ProductListAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ProductViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product_list, parent,false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListAdapter.ProductViewHolder, position: Int) {
        holder.tvProductName.text = productList.get(position).title
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
            val tvProductName : TextView= itemView.findViewById(R.id.tvProductName)

    }
}